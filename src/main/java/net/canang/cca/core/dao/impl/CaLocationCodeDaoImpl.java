package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaLocationCodeDao;
import net.canang.cca.core.model.CaDepartmentCode;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaDepartmentCodeImpl;
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
    public CaDepartmentCode findById(Long id) {
        return (CaDepartmentCode) sessionFactory.getCurrentSession().get(CaDepartmentCodeImpl.class, id);
    }

    @Override
    public CaDepartmentCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaDepartmentCode u where u.code = :code");
        query.setString("code", code);
        return (CaDepartmentCode) query.uniqueResult();
    }

    @Override
    public List<CaDepartmentCode> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaDepartmentCode u");
        return (List<CaDepartmentCode>) query.list();
    }

    @Override
    public void save(CaDepartmentCode departmentCode, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(departmentCode);
    }

    @Override
    public void update(CaDepartmentCode departmentCode, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(departmentCode);
    }

    @Override
    public void remove(CaDepartmentCode departmentCode, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(departmentCode);
    }
}
