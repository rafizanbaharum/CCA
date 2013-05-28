package net.canang.cca.biz.engine.impl;

import net.canang.cca.biz.engine.LedgerManager;
import net.canang.cca.biz.engine.PostingException;
import net.canang.cca.biz.engine.SecurityService;
import net.canang.cca.core.dao.CaBatchDao;
import net.canang.cca.core.dao.CaDocumentDao;
import net.canang.cca.core.dao.CaJournalDao;
import net.canang.cca.core.model.CaBatchJournal;
import net.canang.cca.core.model.CaDocument;
import net.canang.cca.core.model.CaJournal;
import net.canang.cca.core.model.CaPostable;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static net.canang.cca.core.model.CaPostingStatus.POSTED;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
@Service("ledgerManager")
public class LedgerManagerImpl implements LedgerManager {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private CaDocumentDao documentDao;

    @Autowired
    private CaJournalDao journalDao;

    @Autowired
    private CaBatchDao batchDao;

    @Override
    public void post(CaPostable postable) {
        if (postable instanceof CaJournal)
            postJournal((CaJournal) postable);
        else if (postable instanceof CaBatchJournal)
            postBatch((CaBatchJournal) postable);
        else
            throw new PostingException();
    }


    @Override
    public void reverse(CaPostable postable) {
        if (postable instanceof CaJournal)
            reverseJournal((CaJournal) postable);
        else if (postable instanceof CaBatchJournal)
            reverseBatch((CaBatchJournal) postable);
        else
            throw new PostingException();
    }

    private void postJournal(CaJournal journal) {
        Validate.notNull(journal,"Journal cannot be null");
        synchronized (journal) {
            String auditNo = String.valueOf("AUD" + System.currentTimeMillis()).substring(0, 10);
            if (null != journal.getDocument()) {
                journal.setAuditNo(auditNo);
                journal.setPostingStatus(POSTED);
                journal.setPostedDate(new Date());

                CaDocument document = journal.getDocument();
                document.setAuditNo(auditNo);

                documentDao.update(document, securityService.getCurrentUser());
                journalDao.update(journal, securityService.getCurrentUser());
            }
        }
    }

    private void postBatch(CaBatchJournal batchJournal) {
        throw new UnsupportedOperationException();
    }

    private void reverseBatch(CaBatchJournal batchJournal) {
        throw new UnsupportedOperationException();
    }

    private void reverseJournal(CaJournal journal) {
        throw new UnsupportedOperationException();
    }
}
