package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaBatchInvoice;
import net.canang.cca.core.model.CaInvoice;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class CaBatchInvoiceImpl extends CaBatchDocumentImpl implements CaBatchInvoice {

    private List<CaInvoice> invoices;

    public List<CaInvoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<CaInvoice> invoices) {
        this.invoices = invoices;
    }
}
