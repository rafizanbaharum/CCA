package net.canang.cca.biz.engine.impl;

import net.canang.cca.biz.engine.ReferenceNoService;
import net.canang.cca.biz.engine.SalesManager;
import net.canang.cca.biz.engine.SecurityService;
import net.canang.cca.core.dao.CaSalesInvoiceDao;
import net.canang.cca.core.dao.CaSalesOrderDao;
import net.canang.cca.core.model.*;
import net.canang.cca.core.model.impl.CaSalesInvoiceImpl;
import net.canang.cca.core.model.impl.CaSalesInvoiceItemImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
@Component("salesManager")
public class SalesManagerImpl implements SalesManager {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private ReferenceNoService referenceNoService;

    @Autowired
    private CaSalesOrderDao salesOrderDao;

    @Autowired
    private CaSalesInvoiceDao salesInvoiceDao;

    @Override
    public CaSalesInvoice applyToSalesInvoice(CaSalesOrder salesOrder) {
        CaSalesInvoice salesInvoice = new CaSalesInvoiceImpl();
        salesInvoice.setReferenceNo(referenceNoService.generate(CaDocumentType.SALES_INVOICE));
        salesInvoice.setDocumentType(CaDocumentType.SALES_INVOICE);
        salesInvoice.setPostingStatus(CaPostingStatus.UNPOSTED);
        salesInvoice.setWorkflowPriority(salesOrder.getWorkflowPriority());
        salesInvoice.setDepositAmount(BigDecimal.ZERO);
        salesInvoice.setPaymentAmount(BigDecimal.ZERO);
        salesInvoiceDao.save(salesInvoice, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(salesInvoice);

        List<CaSalesInvoiceItem> invoiceItems = new ArrayList<CaSalesInvoiceItem>();
        List<CaSalesOrderItem> orderItems = salesOrderDao.findItems(salesOrder);
        for (CaSalesOrderItem orderItem : orderItems) {
            CaSalesInvoiceItem invoiceItem= new CaSalesInvoiceItemImpl();
            invoiceItem.setFulfilledDate(orderItem.getFulfilledDate());
            invoiceItem.setShippedDate(orderItem.getShippedDate());
            invoiceItem.setQuantityAllocated(orderItem.getQuantityAllocated());
            invoiceItem.setQuantityBilled(orderItem.getQuantityToInvoice());
            invoiceItem.setQuantityFulfilled(orderItem.getQuantityFulfilled());
            invoiceItem.setQuantityToBackOrder(orderItem.getQuantityToBackOrder());
            invoiceItem.setOrder(salesOrder);
            invoiceItems.add(invoiceItem);
        }

        salesInvoiceDao.addItems(salesInvoice, invoiceItems, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
        return salesInvoice;
    }

    @Override
    public void post(CaPostable postable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reverse(CaPostable postable) {
        throw new UnsupportedOperationException();
    }
}
