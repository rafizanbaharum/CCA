package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaItemDao;
import net.canang.cca.core.model.CaItem;
import net.canang.cca.core.model.CaItemPrice;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaItemImpl;
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
public class CaItemDaoImpl implements CaItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CaItem findById(Long id) {
        return (CaItem) sessionFactory.getCurrentSession().get(CaItemImpl.class, id);
    }

    @Override
    public CaItem findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaItem u where u.code = :code");
        query.setString("code", code);
        return (CaItem) query.uniqueResult();
    }

    @Override
    public List<CaItem> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaItem u");
        return (List<CaItem>) query.list();
    }

    @Override
    public void save(CaItem item, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(item);
    }

    @Override
    public void update(CaItem item, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(item);
    }

    @Override
    public void remove(CaItem item, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(item);
    }

    @Override
    public void addPriceLevel(CaItem item, CaItemPrice price, CaUser user) {
        Session session = sessionFactory.getCurrentSession();
        price.setItem(item);
        session.save(price);
    }

    @Override
    public void addPriceLevels(CaItem item, List<CaItemPrice> prices, CaUser user) {
        for (CaItemPrice price : prices) {
            addPriceLevel(item, price, user);
        }
    }
}
