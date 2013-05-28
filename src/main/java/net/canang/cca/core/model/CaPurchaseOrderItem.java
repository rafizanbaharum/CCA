package net.canang.cca.core.model;

import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/28/13
 */
public interface CaPurchaseOrderItem {

    String getDescription();

    CaItem getItem();

    CaSite getSite();

    CaUnitCode getUnitCode();

    BigDecimal getUnitCost();

    BigDecimal getExtendedCost();

    BigDecimal getQuantityOrdered();

    BigDecimal getQuantityCanceled();
}
