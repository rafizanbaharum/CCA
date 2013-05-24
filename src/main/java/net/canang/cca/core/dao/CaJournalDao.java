package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaJournal;
import net.canang.cca.core.model.CaPosting;
import net.canang.cca.core.model.CaUser;
import org.springframework.stereotype.Component;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
@Component("journalDao")
public interface CaJournalDao {

    CaJournal findById(Long id);

    CaJournal findByReferenceNo(String referenceNo);

    CaJournal findBySourceNo(String sourceNo);

    CaJournal findByAuditNo(String auditNo);

    void save(CaJournal journal, CaUser user);

    void addPosting(CaJournal journal, CaPosting posting, CaUser user);

    void update(CaJournal journal, CaUser user);
}
