package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaSalesOrder;
import net.canang.cca.core.model.CaSalesOrderItem;
import net.canang.cca.core.model.CaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaSalesOrderDao {

    CaSalesOrder findById(Long id);

    CaSalesOrder findByReferenceNo(String referenceNo);

    CaSalesOrder findBySourceNo(String sourceNo);

    CaSalesOrder findByAuditNo(String auditNo);

    List<CaSalesOrder> find();

    List<CaSalesOrderItem> findItems(CaSalesOrder order);

    void save(CaSalesOrder order, CaUser user);

    void update(CaSalesOrder order, CaUser user);

    void remove(CaSalesOrder order, CaUser user);

    void addItem(CaSalesOrder order, CaSalesOrderItem orderItem, CaUser user);
}
