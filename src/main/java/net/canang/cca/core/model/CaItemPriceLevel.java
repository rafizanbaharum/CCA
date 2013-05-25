package net.canang.cca.core.model;

import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public interface CaItemPriceLevel extends CaMetaObject, CaCodeable {

    CaItem getItem();

    CaUnitCode getUnitCode();

    BigDecimal getPercent();

    BigDecimal getPrice();

    BigDecimal getStartQuantity();

    BigDecimal getEndQuantity();

}
