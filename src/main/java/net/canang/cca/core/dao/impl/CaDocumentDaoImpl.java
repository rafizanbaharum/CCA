package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaDocumentDao;
import net.canang.cca.core.model.CaDocument;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaDocumentImpl;
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
@Repository("documentDao")
@Transactional
public class CaDocumentDaoImpl implements CaDocumentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CaDocument findById(Long id) {
        return (CaDocument) sessionFactory.getCurrentSession().get(CaDocumentImpl.class, id);
    }

    @Override
    public CaDocument findByReferenceNo(String referenceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaDocument u where u.referenceNo = :referenceNo");
        query.setString("referenceNo", referenceNo);
        return (CaDocument) query.uniqueResult();

    }

    @Override
    public CaDocument findBySourceNo(String sourceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaDocument u where u.sourceNo = :sourceNo");
        query.setString("sourceNo", sourceNo);
        return (CaDocument) query.uniqueResult();

    }

    @Override
    public CaDocument findByAuditNo(String auditNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaDocument u where u.auditNo = :auditNo");
        query.setString("auditNo", auditNo);
        return (CaDocument) query.uniqueResult();

    }


    @Override
    public List<CaDocument> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaDocument u");
        return (List<CaDocument>) query.list();
    }

    @Override
    public void save(CaDocument document, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(document);
    }

    @Override
    public void update(CaDocument document, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(document);
    }

    @Override
    public void remove(CaDocument document, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(document);
    }
}

