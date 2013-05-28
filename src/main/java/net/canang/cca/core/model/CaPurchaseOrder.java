package net.canang.cca.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public interface CaPurchaseOrder extends CaDocument {

//    CaVendor getVendor();
//
//    void setVendor(CaVendor vendor);

    CaPurchaseOrderType getPurchaseOrderType();

    void setPurchaseOrderType(CaPurchaseOrderType purchaseOrderType);

    CaWorkflowPriority getWorkflowPriority();

    void setWorkflowPriority(CaWorkflowPriority workflowPriority);

    List<CaPurchaseOrderItem> getItems();
}
