package net.canang.cca.core.model;

import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaInvoiceItem extends CaMetaObject {

    CaItemCode getItemCode();

    String getDescription();

    BigDecimal getQuantity();

    BigDecimal getUnitCost();

    BigDecimal getUnitPrice();

    CaInvoice getInvoice();

    CaInvoiceItemMarkdownInfo getMarkdownInfo();

}
