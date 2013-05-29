package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaSiteDao;
import net.canang.cca.core.model.CaSiteCode;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaSiteCodeImpl;
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
    public CaSiteCode findById(Long id) {
        return (CaSiteCode) sessionFactory.getCurrentSession().get(CaSiteCodeImpl.class, id);
    }

    @Override
    public CaSiteCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaSiteCode u where u.code = :code");
        query.setString("code", code);
        return (CaSiteCode) query.uniqueResult();
    }

    @Override
    public List<CaSiteCode> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaSiteCode u");
        return (List<CaSiteCode>) query.list();
    }

    @Override
    public void save(CaSiteCode item, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(item);
    }

    @Override
    public void update(CaSiteCode item, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(item);
    }

    @Override
    public void remove(CaSiteCode item, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(item);
    }
}
