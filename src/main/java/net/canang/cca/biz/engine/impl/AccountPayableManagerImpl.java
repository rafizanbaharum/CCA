package net.canang.cca.biz.engine.impl;

import net.canang.cca.biz.engine.AccountPayableManager;
import net.canang.cca.biz.engine.PostingEvent;
import net.canang.cca.biz.engine.SecurityService;
import net.canang.cca.core.dao.CaInvoiceDao;
import net.canang.cca.core.model.*;
import net.canang.cca.core.model.impl.CaInvoiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class AccountPayableManagerImpl implements AccountPayableManager {

    @Autowired
    private CaInvoiceDao invoiceDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private ApplicationContext applicationContext;


    @Override
    public CaDocument draft(CaDocumentType type, CaBatchDocument batchDocument) {
        CaDocument document = null;
        switch (type) {
            case INVOICE:
                document = draft(type, batchDocument);
                break;
            case SALES_ORDER:
                break;
            case PURCHASE_ORDER:
                break;
        }
        return document;
    }

    @Override
    public void update(CaDocument document) {
        invoiceDao.update((CaInvoice) document, securityService.getCurrentUser());
    }


    @Override
    public void post(CaDocument document) {
        applicationContext.publishEvent(new PostingEvent(this, document));
    }

    @Override
    public void post(CaBatchDocument batchDocument) {
        applicationContext.publishEvent(new PostingEvent(this, batchDocument));
    }

    private CaInvoice draft(CaBatchInvoice batch) {
        CaInvoice invoice = new CaInvoiceImpl();
        invoice.setReferenceNo("XXXX"); // TODO: refno service?
        invoice.setSuspended(false);
        invoice.setBatch(batch);

        invoiceDao.save(invoice, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().refresh(invoice);

        return invoice;
    }
}
