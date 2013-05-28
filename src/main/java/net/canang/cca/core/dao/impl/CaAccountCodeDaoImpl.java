package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaAccountCodeDao;
import net.canang.cca.core.model.CaAccountCode;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaAccountCodeImpl;
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
@Repository("accountCodeDao")
@Transactional
public class CaAccountCodeDaoImpl implements CaAccountCodeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CaAccountCode findById(Long id) {
        return (CaAccountCode) sessionFactory.getCurrentSession().get(CaAccountCodeImpl.class, id);
    }

    @Override
    public CaAccountCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaAccountCode u where u.code = :code");
        query.setString("code", code);
        return (CaAccountCode) query.uniqueResult();
    }

    @Override
    public List<CaAccountCode> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaAccountCode u");
        return (List<CaAccountCode>) query.list();
    }

    @Override
    public void save(CaAccountCode accountCode, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(accountCode);
    }

    @Override
    public void update(CaAccountCode accountCode, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(accountCode);
    }

    @Override
    public void remove(CaAccountCode accountCode, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(accountCode);
    }
}
