package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaBatchInvoice;
import net.canang.cca.core.model.CaChequebook;
import net.canang.cca.core.model.CaInvoice;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class CaBatchInvoiceImpl extends CaBatchDocumentImpl implements CaBatchInvoice {


    private BigDecimal totalAmount;
    private CaChequebook chequebook;
    private List<CaInvoice> invoices;

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public CaChequebook getChequebook() {
        return chequebook;
    }

    public void setChequebook(CaChequebook chequebook) {
        this.chequebook = chequebook;
    }

    public List<CaInvoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<CaInvoice> invoices) {
        this.invoices = invoices;
    }
}
