package net.canang.cca.core.model;

import net.canang.cca.CaConfig;
import net.canang.cca.core.dao.*;
import net.canang.cca.core.model.impl.CaAccountImpl;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/28/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CaConfig.class})
public class CaAccountTest {

    private Logger log = LoggerFactory.getLogger(CaAccountTest.class);

    @Autowired
    private CaLocationCodeDao locationCodeDao;

    @Autowired
    private CaAccountCodeDao accountCodeDao;

    @Autowired
    private CaProjectCodeDao projectCodeDao;

    @Autowired
    private CaAccountDao accountDao;

    @Autowired
    private CaUserDao userDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void createAccount() {
        CaUser user = userDao.findByUsername("admin");
        CaProjectCode projectCode = projectCodeDao.findByCode("00");
        CaDepartmentCode departmentCode = locationCodeDao.findByCode("000");
        List<CaAccountCode> accountCodes = accountCodeDao.find();
        for (CaAccountCode accountCode : accountCodes) {
            CaAccountImpl account = new CaAccountImpl();
            account.setDepartmentCode(departmentCode);
            account.setAccountCode(accountCode);
            account.setProjectCode(projectCode);
            account.setCode(departmentCode.getCode() + "-" + accountCode.getCode() + "-" + projectCode.getCode());
            account.setDescription(accountCode.getDescription() + "-" + departmentCode.getDescription());
            account.setAlias(departmentCode.getCode() + "-" + accountCode.getCode() + "-" + projectCode.getCode());
            account.setPostingType(CaPostingType.BALANCE_SHEET);
            account.setBalanceType(CaBalanceType.CREDIT);
            account.setAccountType(CaAccountType.POSTING_ACCOUNT);
            accountDao.save(account, user);
        }
    }
}

