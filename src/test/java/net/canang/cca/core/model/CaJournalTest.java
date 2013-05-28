package net.canang.cca.core.model;

import net.canang.cca.CaConfig;
import net.canang.cca.core.dao.CaAccountDao;
import net.canang.cca.core.dao.CaJournalDao;
import net.canang.cca.core.dao.CaUserDao;
import net.canang.cca.core.model.impl.CaJournalImpl;
import net.canang.cca.core.model.impl.CaPostingImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 5/28/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CaConfig.class})
@TransactionConfiguration
public class CaJournalTest {

    private Logger log = LoggerFactory.getLogger(CaJournalTest.class);

    @Autowired
    private CaAccountDao accountDao;

    @Autowired
    private CaUserDao userDao;

    @Autowired
    private CaJournalDao journalDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void createJournal() {

        Session session = sessionFactory.openSession();
        CaUser user = userDao.findByUsername("admin");
        CaAccount account1 = accountDao.findByCode("000-1110-00");
        CaAccount account2 = accountDao.findByCode("000-1190-00");
        CaJournal journal = new CaJournalImpl();
        journal.setReferenceNo("JRL" + String.valueOf(System.currentTimeMillis()).substring(0, 10));
        journal.setPostingStatus(CaPostingStatus.UNPOSTED);
        journal.setJournalType(CaJournalType.STANDARD);
        journal.setPostedDate(new Date());
        journalDao.save(journal, user);

        session.flush();
        session.refresh(journal);
        log.info("journal #{}", journal.getId());

        CaPosting debit = new CaPostingImpl();
        debit.setDescription("test");
        debit.setAccount(account1);
        debit.setJournal(journal);
        debit.setAmount(new BigDecimal(1000L));
        CaPosting credit = new CaPostingImpl();
        credit.setDescription("test");
        credit.setAccount(account2);
        credit.setJournal(journal);
        credit.setAmount(new BigDecimal(1000L).negate());

        journalDao.addPosting(journal, debit, user);
        journalDao.addPosting(journal, credit, user);
    }
}


