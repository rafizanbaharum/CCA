import net.canang.cca.core.dao.CaAccountDao;
import net.canang.cca.core.dao.CaCompanyDao;
import net.canang.cca.core.dao.CaJournalDao;
import net.canang.cca.core.dao.CaUserDao;
import net.canang.cca.core.model.*;
import net.canang.cca.core.model.impl.CaJournalImpl;
import net.canang.cca.core.model.impl.CaPostingImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class PostingTest {

    @Autowired
    private CaCompanyDao companyDao;

    @Autowired
    private CaAccountDao accountDao;

    @Autowired
    private CaUserDao userDao;

    @Autowired
    private CaJournalDao journalDao;

    @Test
    public void test() {

        CaUser user = userDao.findByUsername("testuser");
        CaCompany company = companyDao.findByCode("XXX");
        CaAccount account = accountDao.findByCode("000-2100-00");

        CaJournal journal = new CaJournalImpl();
        journal.setPostingStatus(CaPostingStatus.UNPOSTED);
        journal.setJournalType(CaJournalType.STANDARD);

        CaPosting debit = new CaPostingImpl();
        debit.setJournal(journal);
        debit.setAccount(account);
        debit.setAmount(BigDecimal.ZERO);

        CaPosting credit = new CaPostingImpl();
        credit.setJournal(journal);
        credit.setAccount(account);
        credit.setAmount(BigDecimal.ZERO);

        // TODO: ensure atomic
        journalDao.save(journal, user);
        journalDao.addPosting(journal, debit, user);
        journalDao.addPosting(journal, credit, user);
    }
}
