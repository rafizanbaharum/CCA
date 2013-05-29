package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaSiteDao;
import net.canang.cca.core.model.CaSite;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaSiteImpl;
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
@Repository("itemDao")
@Transactional
public class CaItemDaoImpl implements CaSiteDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CaSite findById(Long id) {
        return (CaSite) sessionFactory.getCurrentSession().get(CaSiteImpl.class, id);
    }

    @Override
    public CaSite findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaSite u where u.code = :code");
        query.setString("code", code);
        return (CaSite) query.uniqueResult();
    }

    @Override
    public List<CaSite> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaSite u");
        return (List<CaSite>) query.list();
    }

    @Override
    public void save(CaSite item, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(item);
    }

    @Override
    public void update(CaSite item, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(item);
    }

    @Override
    public void remove(CaSite item, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(item);
    }
}
