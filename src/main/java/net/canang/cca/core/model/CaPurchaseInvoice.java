package net.canang.cca.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public interface CaPurchaseInvoice extends CaDocument {

    CaPurchaseInvoiceType getInvoiceType();

    void setInvoiceType(CaPurchaseInvoiceType invoiceType);

    CaWorkflowPriority getWorkflowPriority();

    void setWorkflowPriority(CaWorkflowPriority workflowPriority);

    CaVendor getVendor();

    void setVendor(CaVendor vendor);

    List<CaPurchaseInvoiceItem> getItems();

    void setItems(List<CaPurchaseInvoiceItem> items);
}
