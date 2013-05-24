package net.canang.cca.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaBatchInvoice extends CaBatchDocument {

    List<CaInvoice> getInvoices();

    void setInvoices(List<CaInvoice> invoices);
}
