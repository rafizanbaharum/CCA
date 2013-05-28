package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaProjectCodeDao;
import net.canang.cca.core.model.CaProjectCode;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaProjectCodeImpl;
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
@Repository("projectCodeDao")
@Transactional
public class CaProjectCodeDaoImpl implements CaProjectCodeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CaProjectCode findById(Long id) {
        return (CaProjectCode) sessionFactory.getCurrentSession().get(CaProjectCodeImpl.class, id);
    }

    @Override
    public CaProjectCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaProjectCode u where u.code = :code");
        query.setString("code", code);
        return (CaProjectCode) query.uniqueResult();
    }

    @Override
    public List<CaProjectCode> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaProjectCode u");
        return (List<CaProjectCode>) query.list();
    }

    @Override
    public void save(CaProjectCode projectCode, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(projectCode);
    }

    @Override
    public void update(CaProjectCode projectCode, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(projectCode);
    }

    @Override
    public void remove(CaProjectCode projectCode, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(projectCode);
    }
}
