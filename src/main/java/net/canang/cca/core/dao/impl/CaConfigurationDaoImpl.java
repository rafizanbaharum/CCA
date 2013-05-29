package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaConfigurationDao;
import net.canang.cca.core.model.CaConfiguration;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaConfigurationImpl;
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
@Repository("configurationDao")
@Transactional
public class CaConfigurationDaoImpl implements CaConfigurationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CaConfiguration findById(Long id) {
        return (CaConfiguration) sessionFactory.getCurrentSession().get(CaConfigurationImpl.class, id);
    }

    @Override
    public CaConfiguration findByKey(String key) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaConfiguration u where u.key = :key");
        query.setString("key", key);
        return (CaConfiguration) query.uniqueResult();
    }

    @Override
    public List<CaConfiguration> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaConfiguration u");
        return (List<CaConfiguration>) query.list();
    }

    @Override
    public void save(CaConfiguration configuration, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(configuration);
    }

    @Override
    public void update(CaConfiguration configuration, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(configuration);
    }

    @Override
    public void remove(CaConfiguration configuration, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(configuration);
    }
}
