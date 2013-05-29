package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaPurchaseInvoiceDao;
import net.canang.cca.core.model.CaPurchaseInvoice;
import net.canang.cca.core.model.CaPurchaseInvoiceItem;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaPurchaseInvoiceImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/26/13
 */
@Repository("purchaseInvoiceDao")
@Transactional
public class CaPurchaseInvoiceDaoImpl implements CaPurchaseInvoiceDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CaPurchaseInvoice findById(Long id) {
        return (CaPurchaseInvoice) sessionFactory.getCurrentSession().get(CaPurchaseInvoiceImpl.class, id);
    }

    @Override
    public CaPurchaseInvoice findByReferenceNo(String referenceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaPurchaseInvoice u where u.referenceNo = :referenceNo");
        query.setString("referenceNo", referenceNo);
        return (CaPurchaseInvoice) query.uniqueResult();

    }

    @Override
    public CaPurchaseInvoice findBySourceNo(String sourceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaPurchaseInvoice u where u.sourceNo = :sourceNo");
        query.setString("sourceNo", sourceNo);
        return (CaPurchaseInvoice) query.uniqueResult();

    }

    @Override
    public CaPurchaseInvoice findByAuditNo(String auditNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaPurchaseInvoice u where u.auditNo = :auditNo");
        query.setString("auditNo", auditNo);
        return (CaPurchaseInvoice) query.uniqueResult();

    }


    @Override
    public List<CaPurchaseInvoice> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaPurchaseInvoice u");
        return (List<CaPurchaseInvoice>) query.list();
    }

    @Override
    public void save(CaPurchaseInvoice purchaseInvoice, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(purchaseInvoice);
    }

    @Override
    public void update(CaPurchaseInvoice purchaseInvoice, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(purchaseInvoice);
    }

    @Override
    public void remove(CaPurchaseInvoice purchaseInvoice, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(purchaseInvoice);
    }

    @Override
    public void addItem(CaPurchaseInvoice purchaseInvoice, CaPurchaseInvoiceItem invoiceItem, CaUser user) {
        Session session = sessionFactory.getCurrentSession();
        invoiceItem.setInvoice(purchaseInvoice);
        session.save(purchaseInvoice);
    }
}

