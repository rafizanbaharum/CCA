package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/28/13
 */
@Entity(name = "CaPurchaseOrder")
@Table(name = "CA_PURCHASE_ORDER")
public class CaPurchaseOrderImpl extends CaDocumentImpl implements CaPurchaseOrder {

    @Column(name = "ORDER_TYPE")
    private CaPurchaseOrderType orderType;

    @Column(name = "WORKFLOW_PRIORITY")
    private CaWorkflowPriority workflowPriority;

    @OneToOne(targetEntity = CaVendorImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VENDOR_ID")
    private CaVendor vendor;

    @OneToMany(targetEntity = CaPurchaseOrderItemImpl.class, mappedBy = "order", fetch = FetchType.LAZY)
    private List<CaPurchaseOrderItem> items;

    public CaPurchaseOrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(CaPurchaseOrderType orderType) {
        this.orderType = orderType;
    }

    public CaWorkflowPriority getWorkflowPriority() {
        return workflowPriority;
    }

    public void setWorkflowPriority(CaWorkflowPriority workflowPriority) {
        this.workflowPriority = workflowPriority;
    }

    public CaVendor getVendor() {
        return vendor;
    }

    public void setVendor(CaVendor vendor) {
        this.vendor = vendor;
    }


    public List<CaPurchaseOrderItem> getItems() {
        return items;
    }

    public void setItems(List<CaPurchaseOrderItem> items) {
        this.items = items;
    }
}
