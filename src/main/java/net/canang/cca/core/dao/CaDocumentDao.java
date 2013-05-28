package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaDocument;
import net.canang.cca.core.model.CaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaDocumentDao {

    CaDocument findById(Long id);

    CaDocument findByReferenceNo(String referenceNo);

    CaDocument findBySourceNo(String sourceNo);

    CaDocument findByAuditNo(String auditNo);

    List<CaDocument> find();

    void save(CaDocument document, CaUser user);

    void update(CaDocument document, CaUser user);

    void remove(CaDocument document, CaUser user);
}
