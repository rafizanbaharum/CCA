package net.canang.cca.core.model;

import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/28/13
 */
public interface CaPurchaseOrderItem {

    String getDescription();

    void setDescription(String description);

    CaItem getItem();

    void setItem(CaItem item);

    CaSite getSite();

    void setSite(CaSite site);

    CaUnitCode getUnitCode();

    void setUnitCode(CaUnitCode unitCode);

    BigDecimal getUnitCost();

    void setUnitCost(BigDecimal unitCost);

    BigDecimal getExtendedCost();

    void setExtendedCost(BigDecimal extendedCost);

    BigDecimal getQuantityOrdered();

    void setQuantityOrdered(BigDecimal quantityOrdered);

    BigDecimal getQuantityCancelled();

    void setQuantityCancelled(BigDecimal quantityCancelled);

    CaPurchaseOrder getOrder();

    void setOrder(CaPurchaseOrder purchaseOrder);
}
