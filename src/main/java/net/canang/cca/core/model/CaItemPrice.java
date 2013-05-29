package net.canang.cca.core.model;

import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public interface CaItemPrice extends CaMetaObject {

    CaItem getItem();

    void setItem(CaItem item);

    CaUnitCode getUnitCode();

    void setUnitCode(CaUnitCode unitCode);

    BigDecimal getPercent();

    void setPercent(BigDecimal percent);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    BigDecimal getStartQuantity();

    void setStartQuantity(BigDecimal startQuantity);

    BigDecimal getEndQuantity();

    void setEndQuantity(BigDecimal endQuantity);

}
