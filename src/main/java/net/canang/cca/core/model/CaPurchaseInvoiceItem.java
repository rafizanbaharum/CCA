package net.canang.cca.core.model;

import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/28/13
 */
public interface CaPurchaseInvoiceItem {

    CaItem getItem();

    void setItem(CaItem item);

    CaSiteCode getSiteCode();

    void setSiteCode(CaSiteCode siteCode);

    CaUnitCode getUnitCode();

    void setUnitCode(CaUnitCode unitCode);

    BigDecimal getUnitCost();

    void setUnitCost(BigDecimal unitCost);

    BigDecimal getExtendedCost();

    void setExtendedCost(BigDecimal extendedCost);

    BigDecimal getQuantityOrdered();

    void setQuantityOrdered(BigDecimal quantityOrdered);

    BigDecimal getQuantityShipped();

    void setQuantityShipped(BigDecimal quantityCancelled);

    CaPurchaseInvoice getInvoice();

    void setInvoice(CaPurchaseInvoice purchaseInvoice);

    CaPurchaseOrder getOrder();

    void setOrder(CaPurchaseOrder purchaseOrder);
}
