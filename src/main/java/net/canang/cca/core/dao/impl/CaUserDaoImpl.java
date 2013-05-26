package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaUserDao;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaUserImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author rafizan.baharum
 * @since 5/26/13
 */
@Repository("userDao")
@Transactional
public class CaUserDaoImpl implements CaUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CaUser findById(Long id) {
        return (CaUser) sessionFactory.getCurrentSession().get(CaUserImpl.class, id);
    }

    @Override
    public CaUser findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaUser u where u.name = :username");
        query.setString("username", username);
        return (CaUser) query.uniqueResult();
    }

    @Override
    public void save(CaUser user, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void update(CaUser user, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void remove(CaUser user, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }
}
