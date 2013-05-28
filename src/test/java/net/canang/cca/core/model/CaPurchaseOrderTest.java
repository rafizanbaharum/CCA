package net.canang.cca.core.model;

import net.canang.cca.CaConfig;
import net.canang.cca.core.dao.*;
import net.canang.cca.core.model.impl.CaJournalImpl;
import net.canang.cca.core.model.impl.CaPurchaseOrderImpl;
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

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 5/28/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CaConfig.class})
@TransactionConfiguration
public class CaPurchaseOrderTest {

    private Logger log = LoggerFactory.getLogger(CaJournalTest.class);

    @Autowired
    private CaPurchaseOrderDao purchaseOrderDao;

    @Autowired
    private CaDocumentDao documentDao;

    @Autowired
    private CaAccountDao accountDao;

    @Autowired
    private CaUserDao userDao;

    @Autowired
    private CaJournalDao journalDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void createPurchaseOrder() {

        Session session = sessionFactory.openSession();
        CaUser user = userDao.findByUsername("admin");
        CaAccount account1 = accountDao.findByCode("000-1110-00");
        CaAccount account2 = accountDao.findByCode("000-1190-00");

        CaPurchaseOrder purchaseOrder = new CaPurchaseOrderImpl();
        purchaseOrder.setReferenceNo("JRL" + String.valueOf(System.currentTimeMillis()).substring(0, 10));
        purchaseOrder.setPostingStatus(CaPostingStatus.UNPOSTED);
        purchaseOrder.setPurchaseOrderType(CaPurchaseOrderType.STANDARD);
        purchaseOrder.setWorkflowPriority(CaWorkflowPriority.LOW);
        purchaseOrder.setPostedDate(new Date());
        purchaseOrderDao.save(purchaseOrder, user);
        session.flush();
        session.refresh(purchaseOrder);
        log.info("purchaseOrder #{}", purchaseOrder.getId());

    }
}
