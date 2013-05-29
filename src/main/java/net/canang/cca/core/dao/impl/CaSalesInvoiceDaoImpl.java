package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaSalesInvoiceDao;
import net.canang.cca.core.model.CaSalesInvoice;
import net.canang.cca.core.model.CaSalesInvoiceItem;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaSalesInvoiceImpl;
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
@Repository("salesInvoiceDao")
@Transactional
public class CaSalesInvoiceDaoImpl implements CaSalesInvoiceDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CaSalesInvoice findById(Long id) {
        return (CaSalesInvoice) sessionFactory.getCurrentSession().get(CaSalesInvoiceImpl.class, id);
    }

    @Override
    public CaSalesInvoice findByReferenceNo(String referenceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaSalesInvoice u where u.referenceNo = :referenceNo");
        query.setString("referenceNo", referenceNo);
        return (CaSalesInvoice) query.uniqueResult();

    }

    @Override
    public CaSalesInvoice findBySourceNo(String sourceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaSalesInvoice u where u.sourceNo = :sourceNo");
        query.setString("sourceNo", sourceNo);
        return (CaSalesInvoice) query.uniqueResult();

    }

    @Override
    public CaSalesInvoice findByAuditNo(String auditNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaSalesInvoice u where u.auditNo = :auditNo");
        query.setString("auditNo", auditNo);
        return (CaSalesInvoice) query.uniqueResult();

    }


    @Override
    public List<CaSalesInvoice> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaSalesInvoice u");
        return (List<CaSalesInvoice>) query.list();
    }

    @Override
    public void save(CaSalesInvoice invoice, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(invoice);
    }

    @Override
    public void update(CaSalesInvoice invoice, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(invoice);
    }

    @Override
    public void remove(CaSalesInvoice invoice, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(invoice);
    }

    @Override
    public void addItem(CaSalesInvoice invoice, CaSalesInvoiceItem invoiceItem, CaUser user) {
        Session session = sessionFactory.getCurrentSession();
        invoiceItem.setInvoice(invoice);
        session.save(invoice);
    }

    @Override
    public void addItems(CaSalesInvoice invoice, List<CaSalesInvoiceItem> invoiceItems, CaUser user) {
        for (CaSalesInvoiceItem invoiceItem : invoiceItems) {
            addItem(invoice, invoiceItem, user);
        }
    }
}

