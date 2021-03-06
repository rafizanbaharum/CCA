package net.canang.cca.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public interface CaPurchaseOrder extends CaDocument {

    CaPurchaseOrderType getOrderType();

    void setOrderType(CaPurchaseOrderType orderType);

    CaWorkflowPriority getWorkflowPriority();

    void setWorkflowPriority(CaWorkflowPriority workflowPriority);

    CaVendor getVendor();

    void setVendor(CaVendor vendor);

    List<CaPurchaseOrderItem> getItems();

    void setItems(List<CaPurchaseOrderItem> items);
}
