package net.canang.cca.core.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaInvoice extends CaDocument{

    BigDecimal getTotalAmount();

    void setTotalAmount(BigDecimal totalAmount);

    boolean isSuspended();

    void setSuspended(boolean suspended);

    CaCustomer getCustomer();

    void setCustomer(CaCustomer customer);

    CaSite getSite();

    void setSite(CaSite site);

    CaBatchInvoice getBatch();

    void setBatch(CaBatchInvoice batch);

    List<CaInvoiceItem> getItems();

    void setItems(List<CaInvoiceItem> items);
}
