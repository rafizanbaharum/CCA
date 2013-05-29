package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaUnitCodeDao;
import net.canang.cca.core.model.CaUnitCode;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaUnitCodeImpl;
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
@Repository("unitCodeDao")
@Transactional
public class CaUnitCodeDaoImpl implements CaUnitCodeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CaUnitCode findById(Long id) {
        return (CaUnitCode) sessionFactory.getCurrentSession().get(CaUnitCodeImpl.class, id);
    }

    @Override
    public CaUnitCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaUnitCode u where u.code = :code");
        query.setString("code", code);
        return (CaUnitCode) query.uniqueResult();
    }

    @Override
    public List<CaUnitCode> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaUnitCode u");
        return (List<CaUnitCode>) query.list();
    }

    @Override
    public void save(CaUnitCode unitCode, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(unitCode);
    }

    @Override
    public void update(CaUnitCode unitCode, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(unitCode);
    }

    @Override
    public void remove(CaUnitCode unitCode, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(unitCode);
    }
}
