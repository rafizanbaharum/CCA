package net.canang.cca.biz.engine;

import net.canang.cca.core.dao.CaBatchJournalDao;
import net.canang.cca.core.dao.CaInvoiceDao;
import net.canang.cca.core.dao.CaJournalDao;
import net.canang.cca.core.model.*;
import net.canang.cca.core.model.impl.CaBatchJournalImpl;
import net.canang.cca.core.model.impl.CaJournalImpl;
import net.canang.cca.core.model.impl.CaPostingImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class PostingListener implements ApplicationListener<PostingEvent> {

    @Autowired
    private LedgerManager ledgerManager;

    @Autowired
    private CaInvoiceDao invoiceDao;

    @Autowired
    private CaJournalDao journalDao;

    @Autowired
    private CaBatchJournalDao batchJournalDao;

    @Autowired
    private ReferenceNoService refNoService;

    @Autowired
    private SecurityService securityService;


    @Override
    public void onApplicationEvent(PostingEvent event) {
        CaPostable postable = event.getPostable();

        // if invoice, convert to journal
        if (postable instanceof CaBatchInvoice)
            serializeToJournal(postable);

        if (postable instanceof CaJournal || postable instanceof CaBatchJournal) {
            ledgerManager.post(postable);
        } else if (postable instanceof CaJournal || postable instanceof CaBatchJournal) {
            ledgerManager.post(postable);
        }
    }

    private void serializeToJournal(CaPostable postable) {
        CaBatchJournalImpl batchJournal = new CaBatchJournalImpl();
        prepareBatchJournal(batchJournal);

        if (postable instanceof CaBatchInvoice) {
            CaBatchInvoice batchInvoice = (CaBatchInvoice) postable;
            List<CaInvoice> invoices = batchInvoice.getInvoices();
            for (CaInvoice invoice : invoices) {
                CaJournalImpl journal = new CaJournalImpl();
                journal.setReferenceNo(refNoService.generate(invoice.getDocumentType()));
                journal.setSourceNo(invoice.getReferenceNo());
                journal.setJournalType(CaJournalType.STANDARD);
                journal.setPostingStatus(CaPostingStatus.UNPOSTED);
                journalDao.save(journal, securityService.getCurrentUser());

                generateDebit(batchInvoice, invoice, journal);
                generateCredit(batchInvoice, invoice, journal);

                batchJournalDao.addJournal(batchJournal,journal,securityService.getCurrentUser());
            }
        }
    }

    private void prepareBatchJournal(CaBatchJournal batchJournal) {
        batchJournal.setBatchFrequency(CaBatchFrequency.SINGLE_USE);
        batchJournal.setBatchStatus(CaBatchStatus.OPENED);
        batchJournal.setBatchType(CaBatchType.GENERAL_ENTRY);
        batchJournalDao.save(batchJournal, securityService.getCurrentUser());
    }

    private void generateDebit(CaBatchInvoice batch, CaInvoice invoice, CaJournalImpl journal) {
        List<CaInvoiceItem> items = invoice.getItems();
        for (CaInvoiceItem item : items) {
            // debit
            CaPosting posting = new CaPostingImpl();
            // TODO: customer or item?
            // customer.getSalesAccount()
            // item.getAccount();
            posting.setAccount(invoice.getCustomer().getSalesAccount());
            posting.setAmount(item.getMarkdownInfo().getExtendedPrice());
            // posting.setCompany(); // TODO:
            posting.setJournal(journal);
            journalDao.addPosting(journal, posting, securityService.getCurrentUser());
        }
    }

    private void generateCredit(CaBatchInvoice batch, CaInvoice invoice, CaJournalImpl journal) {
        CaPosting posting = new CaPostingImpl();
        posting.setAccount(batch.getChequebook().getAccount());
        posting.setAmount(invoice.getTotalAmount());
        // posting.setCompany(); // TODO:
        posting.setJournal(journal);
        journalDao.addPosting(journal, posting, securityService.getCurrentUser());
    }
}
