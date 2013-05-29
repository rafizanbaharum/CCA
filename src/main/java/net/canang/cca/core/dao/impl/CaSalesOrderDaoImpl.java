package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaSalesOrderDao;
import net.canang.cca.core.model.CaSalesOrder;
import net.canang.cca.core.model.CaSalesOrderItem;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaSalesOrderImpl;
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
@Repository("salesOrderDao")
@Transactional
public class CaSalesOrderDaoImpl implements CaSalesOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CaSalesOrder findById(Long id) {
        return (CaSalesOrder) sessionFactory.getCurrentSession().get(CaSalesOrderImpl.class, id);
    }

    @Override
    public CaSalesOrder findByReferenceNo(String referenceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaSalesOrder u where u.referenceNo = :referenceNo");
        query.setString("referenceNo", referenceNo);
        return (CaSalesOrder) query.uniqueResult();

    }

    @Override
    public CaSalesOrder findBySourceNo(String sourceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaSalesOrder u where u.sourceNo = :sourceNo");
        query.setString("sourceNo", sourceNo);
        return (CaSalesOrder) query.uniqueResult();

    }

    @Override
    public CaSalesOrder findByAuditNo(String auditNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaSalesOrder u where u.auditNo = :auditNo");
        query.setString("auditNo", auditNo);
        return (CaSalesOrder) query.uniqueResult();

    }


    @Override
    public List<CaSalesOrder> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaSalesOrder u");
        return (List<CaSalesOrder>) query.list();
    }

    @Override
    public List<CaSalesOrderItem> findItems(CaSalesOrder order) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select soi from CaSalesOrderItem soi");
        return (List<CaSalesOrderItem>) query.list();
    }

    @Override
    public void save(CaSalesOrder salesOrder, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(salesOrder);
    }

    @Override
    public void update(CaSalesOrder salesOrder, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(salesOrder);
    }

    @Override
    public void remove(CaSalesOrder salesOrder, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(salesOrder);
    }

    @Override
    public void addItem(CaSalesOrder salesOrder, CaSalesOrderItem orderItem, CaUser user) {
        Session session = sessionFactory.getCurrentSession();
        orderItem.setOrder(salesOrder);
        session.save(salesOrder);
    }
}

