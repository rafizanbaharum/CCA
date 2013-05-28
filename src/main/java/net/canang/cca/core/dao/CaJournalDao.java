package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaJournal;
import net.canang.cca.core.model.CaPosting;
import net.canang.cca.core.model.CaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaJournalDao {

    CaJournal findById(Long id);

    CaJournal findByReferenceNo(String referenceNo);

    CaJournal findBySourceNo(String sourceNo);

    CaJournal findByAuditNo(String auditNo);

    List<CaJournal> find();

    void save(CaJournal journal, CaUser user);

    void update(CaJournal journal, CaUser user);

    void remove(CaJournal journal, CaUser user);

    void addPosting(CaJournal journal, CaPosting posting, CaUser user);
}
