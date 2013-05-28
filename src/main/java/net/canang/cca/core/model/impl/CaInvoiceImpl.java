package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class CaInvoiceImpl extends CaDocumentImpl implements CaInvoice {

    private boolean suspended;
    private BigDecimal totalAmount;
    private CaCustomer customer;
    private CaSite site;

    private CaBatchInvoice batch;
    private List<CaInvoiceItem> items;

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public CaCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(CaCustomer customer) {
        this.customer = customer;
    }

    public CaSite getSite() {
        return site;
    }

    public void setSite(CaSite site) {
        this.site = site;
    }

    public CaBatchInvoice getBatch() {
        return batch;
    }

    public void setBatch(CaBatchInvoice batch) {
        this.batch = batch;
    }

    public List<CaInvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<CaInvoiceItem> items) {
        this.items = items;
    }
}
