package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaBatchJournal;
import net.canang.cca.core.model.CaJournal;
import net.canang.cca.core.model.CaUser;
import org.springframework.stereotype.Component;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
@Component("batchJournalDao")
public interface CaBatchJournalDao {

    CaBatchJournal findById(Long id);

    CaBatchJournal findByReferenceNo(String referenceNo);

    CaBatchJournal findBySourceNo(String sourceNo);

    CaBatchJournal findByAuditNo(String auditNo);

    void save(CaBatchJournal journal, CaUser user);

    void addJournal(CaBatchJournal batchJournal, CaJournal journal, CaUser user);

    void update(CaBatchJournal journal, CaUser user);
}
