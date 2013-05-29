package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaConsumerDao;
import net.canang.cca.core.model.CaConsumer;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaConsumerImpl;
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
@Repository("consumerDao")
@Transactional
public class CaConsumerDaoImpl implements CaConsumerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CaConsumer findById(Long id) {
        return (CaConsumer) sessionFactory.getCurrentSession().get(CaConsumerImpl.class, id);
    }

    @Override
    public CaConsumer findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaConsumer u where u.code = :code");
        query.setString("code", code);
        return (CaConsumer) query.uniqueResult();
    }

    @Override
    public List<CaConsumer> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaConsumer u");
        return (List<CaConsumer>) query.list();
    }

    @Override
    public void save(CaConsumer consumer, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(consumer);
    }

    @Override
    public void update(CaConsumer consumer, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(consumer);
    }

    @Override
    public void remove(CaConsumer consumer, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(consumer);
    }
}

