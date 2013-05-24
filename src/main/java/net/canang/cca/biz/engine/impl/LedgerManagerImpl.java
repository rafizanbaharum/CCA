package net.canang.cca.biz.engine.impl;

import net.canang.cca.biz.engine.LedgerManager;
import net.canang.cca.biz.engine.PostingException;
import net.canang.cca.biz.engine.SecurityService;
import net.canang.cca.core.dao.CaBatchDao;
import net.canang.cca.core.dao.CaJournalDao;
import net.canang.cca.core.model.CaBatchJournal;
import net.canang.cca.core.model.CaJournal;
import net.canang.cca.core.model.CaPostable;
import org.springframework.beans.factory.annotation.Autowired;

import static net.canang.cca.core.model.CaPostingStatus.POSTED;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class LedgerManagerImpl implements LedgerManager {

    @Autowired
    private SecurityService securityService;

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
        // change status to POSTED
        // generate auditNo
        // TODO: atomic
        journal.setPostingStatus(POSTED);
        journal.setAuditNo("XXX");
        journalDao.update(journal, securityService.getCurrentUser());
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
