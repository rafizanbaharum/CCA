package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaPurchaseOrderDao;
import net.canang.cca.core.model.CaPurchaseOrder;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaPurchaseOrderImpl;
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
@Repository("purchaseOrderDao")
@Transactional
public class CaPurchaseOrderDaoImpl implements CaPurchaseOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CaPurchaseOrder findById(Long id) {
        return (CaPurchaseOrder) sessionFactory.getCurrentSession().get(CaPurchaseOrderImpl.class, id);
    }

    @Override
    public CaPurchaseOrder findByReferenceNo(String referenceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaPurchaseOrder u where u.referenceNo = :referenceNo");
        query.setString("referenceNo", referenceNo);
        return (CaPurchaseOrder) query.uniqueResult();

    }

    @Override
    public CaPurchaseOrder findBySourceNo(String sourceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaPurchaseOrder u where u.sourceNo = :sourceNo");
        query.setString("sourceNo", sourceNo);
        return (CaPurchaseOrder) query.uniqueResult();

    }

    @Override
    public CaPurchaseOrder findByAuditNo(String auditNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaPurchaseOrder u where u.auditNo = :auditNo");
        query.setString("auditNo", auditNo);
        return (CaPurchaseOrder) query.uniqueResult();

    }


    @Override
    public List<CaPurchaseOrder> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaPurchaseOrder u");
        return (List<CaPurchaseOrder>) query.list();
    }

    @Override
    public void save(CaPurchaseOrder purchaseOrder, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(purchaseOrder);
    }

    @Override
    public void update(CaPurchaseOrder purchaseOrder, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(purchaseOrder);
    }

    @Override
    public void remove(CaPurchaseOrder purchaseOrder, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(purchaseOrder);

    }
}

