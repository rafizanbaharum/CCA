package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaAccountDao;
import net.canang.cca.core.model.CaAccount;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaAccountImpl;
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
@Repository("accountDao")
@Transactional
public class  CaAccountDaoImpl implements CaAccountDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CaAccount findById(Long id) {
        return (CaAccount) sessionFactory.getCurrentSession().get(CaAccountImpl.class, id);
    }

    @Override
    public CaAccount findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaAccount u where u.code = :code");
        query.setString("code", code);
        return (CaAccount) query.uniqueResult();
    }

    @Override
    public List<CaAccount> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaAccount u");
        return (List<CaAccount>) query.list();
    }

    @Override
    public void save(CaAccount account, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(account);
    }

    @Override
    public void update(CaAccount account, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(account);
    }

    @Override
    public void remove(CaAccount account, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(account);
    }
}
