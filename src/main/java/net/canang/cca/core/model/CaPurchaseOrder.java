package net.canang.cca.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public interface CaPurchaseOrder extends CaDocument {

    CaPurchaseOrderStatus getPurchaseOrderStatus();

    CaWorkflowPriority getWorkflowPriority();

    List<CaPurchaseOrderItem> getItems();
}
