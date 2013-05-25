package net.canang.cca.core.model;

import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaInvoiceItem extends CaMetaObject {

    CaItemCode getItemCode();

    void setItemCode(CaItemCode itemCode);

    String getDescription();

    void setDescription(String description);

    BigDecimal getQuantity();

    void setQuantity(BigDecimal quantity);

    BigDecimal getUnitCost();

    void setUnitCost(BigDecimal unitCost);

    BigDecimal getUnitPrice();

    void setUnitPrice(BigDecimal unitPrice);

    boolean isMarkdowned();

    void setMarkdowned(boolean markdowned);

    CaInvoice getInvoice();

    void setInvoice(CaInvoice invoice);

    CaInvoiceItemMarkdownInfo getMarkdownInfo();

    void setMarkdownInfo(CaInvoiceItemMarkdownInfo markdownInfo);

}
