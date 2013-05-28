package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaLocationCodeDao;
import net.canang.cca.core.model.CaLocationCode;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaLocationCodeImpl;
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
@Repository("locationCodeDao")
@Transactional
public class CaLocationCodeDaoImpl implements CaLocationCodeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CaLocationCode findById(Long id) {
        return (CaLocationCode) sessionFactory.getCurrentSession().get(CaLocationCodeImpl.class, id);
    }

    @Override
    public CaLocationCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaLocationCode u where u.code = :code");
        query.setString("code", code);
        return (CaLocationCode) query.uniqueResult();
    }

    @Override
    public List<CaLocationCode> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaLocationCode u");
        return (List<CaLocationCode>) query.list();
    }

    @Override
    public void save(CaLocationCode locationCode, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(locationCode);
    }

    @Override
    public void update(CaLocationCode locationCode, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(locationCode);
    }

    @Override
    public void remove(CaLocationCode locationCode, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(locationCode);
    }
}
