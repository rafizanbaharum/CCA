package net.canang.cca.core.dao.impl;

import net.canang.cca.core.dao.CaBatchDao;
import net.canang.cca.core.model.CaBatchJournal;
import net.canang.cca.core.model.CaPosting;
import net.canang.cca.core.model.CaUser;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author rafizan.baharum
 * @since 5/28/13
 */
@Component("batchDao")
@Transactional
public class CaBatchDaoImpl implements CaBatchDao {

    @Override
    public CaBatchJournal findById(Long id) {
        return null;  // TODO:

    }

    @Override
    public CaBatchJournal findByReferenceNo(String referenceNo) {
        return null;  // TODO:

    }

    @Override
    public CaBatchJournal findBySourceNo(String sourceNo) {
        return null;  // TODO:

    }

    @Override
    public CaBatchJournal findByAuditNo(String auditNo) {
        return null;  // TODO:

    }

    @Override
    public void save(CaBatchJournal batchJournal, CaUser user) {
        // TODO:

    }

    @Override
    public void addPosting(CaBatchJournal batchJournal, CaPosting posting) {
        // TODO:

    }

    @Override
    public void post(CaBatchJournal batchJournal) {
        // TODO:

    }
}
