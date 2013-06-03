package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/28/13
 */
@Entity(name = "CaPurchaseInvoice")
@Table(name = "CA_PURCHASE_INVOICE")
public class CaPurchaseInvoiceImpl extends CaDocumentImpl implements CaPurchaseInvoice {

    @Column(name = "INVOICE_TYPE")
    private CaPurchaseInvoiceType invoiceType;

    @Column(name = "WORKFLOW_PRIORITY")
    private CaWorkflowPriority workflowPriority;

    @OneToOne(targetEntity = CaVendorImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VENDOR_ID")
    private CaVendor vendor;

    @OneToMany(targetEntity = CaPurchaseInvoiceItemImpl.class, mappedBy = "invoice", fetch = FetchType.LAZY)
    private List<CaPurchaseInvoiceItem> items;

    public CaPurchaseInvoiceType getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(CaPurchaseInvoiceType invoiceType) {
        this.invoiceType = invoiceType;
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


    public List<CaPurchaseInvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<CaPurchaseInvoiceItem> items) {
        this.items = items;
    }
}
