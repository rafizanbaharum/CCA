package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaJournalDao;
import net.canang.cca.core.model.CaJournal;
import net.canang.cca.core.model.CaPosting;
import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.impl.CaJournalImpl;
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
@Repository("journalDao")
@Transactional
public class CaJournalDaoImpl implements CaJournalDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CaJournal findById(Long id) {
        return (CaJournal) sessionFactory.getCurrentSession().get(CaJournalImpl.class, id);
    }

    @Override
    public CaJournal findByReferenceNo(String referenceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaJournal u where u.referenceNo = :referenceNo");
        query.setString("referenceNo", referenceNo);
        return (CaJournal) query.uniqueResult();

    }

    @Override
    public CaJournal findBySourceNo(String sourceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaJournal u where u.sourceNo = :sourceNo");
        query.setString("sourceNo", sourceNo);
        return (CaJournal) query.uniqueResult();

    }

    @Override
    public CaJournal findByAuditNo(String auditNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaJournal u where u.auditNo = :auditNo");
        query.setString("auditNo", auditNo);
        return (CaJournal) query.uniqueResult();

    }


    @Override
    public List<CaJournal> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CaJournal u");
        return (List<CaJournal>) query.list();
    }

    @Override
    public void save(CaJournal journal, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.save(journal);
    }

    @Override
    public void update(CaJournal journal, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(journal);
    }

    @Override
    public void remove(CaJournal journal, CaUser creator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(journal);
    }


    @Override
    public void addPosting(CaJournal journal, CaPosting posting, CaUser user) {
        Session session = sessionFactory.getCurrentSession();
        posting.setJournal(journal);
        session.save(posting);
    }

}

