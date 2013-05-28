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
@Inheritance(strategy = InheritanceType.JOINED)
public class CaPurchaseOrderImpl extends CaDocumentImpl implements CaPurchaseOrder {

    @Column(name = "PURCHASE_ORDER_TYPE")
    private CaPurchaseOrderType purchaseOrderType;

    @Column(name = "WORKFLOW_PRIORITY")
    private CaWorkflowPriority workflowPriority;

//    @OneToOne(targetEntity = CaVendorImpl.class, fetch = FetchType.LAZY)
//    @Column(name = "VENDOR_ID")
//    private CaVendor vendor;

    @Transient // TODO: for now
    private List<CaPurchaseOrderItem> items;

//    public CaVendor getVendor() {
//        return vendor;
//    }
//
//    public void setVendor(CaVendor vendor) {
//        this.vendor = vendor;
//    }
//
    public CaPurchaseOrderType getPurchaseOrderType() {
        return purchaseOrderType;
    }

    public void setPurchaseOrderType(CaPurchaseOrderType purchaseOrderType) {
        this.purchaseOrderType = purchaseOrderType;
    }

    public CaWorkflowPriority getWorkflowPriority() {
        return workflowPriority;
    }

    public void setWorkflowPriority(CaWorkflowPriority workflowPriority) {
        this.workflowPriority = workflowPriority;
    }

    public List<CaPurchaseOrderItem> getItems() {
        return items;
    }

    public void setItems(List<CaPurchaseOrderItem> items) {
        this.items = items;
    }
}
