package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaBatchJournal;
import net.canang.cca.core.model.CaPosting;
import net.canang.cca.core.model.CaUser;
import org.springframework.stereotype.Component;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
@Component("batchDao")
public interface CaBatchDao {

    CaBatchJournal findById(Long id);

    CaBatchJournal findByReferenceNo(String referenceNo);

    CaBatchJournal findBySourceNo(String sourceNo);

    CaBatchJournal findByAuditNo(String auditNo);

    void save(CaBatchJournal batchJournal, CaUser user);

    void addPosting(CaBatchJournal batchJournal, CaPosting posting);

    void post(CaBatchJournal batchJournal);
}
