package net.canang.cca.core.model;

import net.canang.cca.CaConfig;
import net.canang.cca.core.dao.*;
import net.canang.cca.core.model.impl.CaPurchaseOrderImpl;
import net.canang.cca.core.model.impl.CaPurchaseOrderItemImpl;
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
public class CaPurchaseOrderTest {

    private Logger log = LoggerFactory.getLogger(CaJournalTest.class);

    @Autowired
    private CaPurchaseOrderDao purchaseOrderDao;

    @Autowired
    private CaDocumentDao documentDao;

    @Autowired
    private CaSiteDao siteDao;

    @Autowired
    private CaItemDao itemDao;

    @Autowired
    private CaVendorDao vendorDao;

    @Autowired
    private CaAccountDao accountDao;

    @Autowired
    private CaUnitCodeDao unitCodeDao;

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
        CaVendor vendor = vendorDao.findByCode("000-1190-00");
        CaSiteCode siteCode = siteDao.findByCode("000-1190-00");
        CaUnitCode unitCode = unitCodeDao.findByCode("000-1190-00");
        CaItem item = itemDao.findByCode("000-1190-00");

        CaPurchaseOrder purchaseOrder = new CaPurchaseOrderImpl();
        purchaseOrder.setReferenceNo("JRL" + String.valueOf(System.currentTimeMillis()).substring(0, 10));
        purchaseOrder.setPostingStatus(CaPostingStatus.UNPOSTED);
        purchaseOrder.setOrderType(CaPurchaseOrderType.STANDARD);
        purchaseOrder.setWorkflowPriority(CaWorkflowPriority.LOW);
        purchaseOrder.setPostedDate(new Date());
        purchaseOrder.setVendor(vendor);
        purchaseOrderDao.save(purchaseOrder, user);
        session.flush();
        session.refresh(purchaseOrder);
        log.info("purchaseOrder #{}", purchaseOrder.getId());

        // NOTE: all inventoried item
        CaPurchaseOrderItem orderItem1 = new CaPurchaseOrderItemImpl();
        orderItem1.setDescription("item 1");
        orderItem1.setItem(item);
        orderItem1.setSiteCode(siteCode);
        orderItem1.setUnitCode(unitCode);
        orderItem1.setUnitCost(BigDecimal.valueOf(0.01));
        orderItem1.setExtendedCost(BigDecimal.valueOf(0.01));
        orderItem1.setQuantityOrdered(BigDecimal.valueOf(999999));
        orderItem1.setQuantityCancelled(BigDecimal.ZERO);

        CaPurchaseOrderItem orderItem2 = new CaPurchaseOrderItemImpl();
        orderItem2.setDescription("item 2");
        orderItem2.setItem(item);
        orderItem2.setSiteCode(siteCode);
        orderItem2.setUnitCode(unitCode);
        orderItem2.setUnitCost(BigDecimal.valueOf(0.01));
        orderItem2.setExtendedCost(BigDecimal.valueOf(0.01));
        orderItem2.setQuantityOrdered(BigDecimal.valueOf(888888));
        orderItem2.setQuantityCancelled(BigDecimal.ZERO);

        purchaseOrderDao.addItem(purchaseOrder, orderItem1, user);
        purchaseOrderDao.addItem(purchaseOrder, orderItem2, user);
    }
}
