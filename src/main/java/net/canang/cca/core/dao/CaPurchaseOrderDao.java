package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaPurchaseOrder;
import net.canang.cca.core.model.CaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaPurchaseOrderDao {

    CaPurchaseOrder findById(Long id);

    CaPurchaseOrder findByReferenceNo(String referenceNo);

    CaPurchaseOrder findBySourceNo(String sourceNo);

    CaPurchaseOrder findByAuditNo(String auditNo);

    List<CaPurchaseOrder> find();

    void save(CaPurchaseOrder order, CaUser user);

    void update(CaPurchaseOrder order, CaUser user);

    void remove(CaPurchaseOrder order, CaUser user);
}
