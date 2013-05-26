package net.canang.cca.core.model;

import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public interface CaBackOrderItem extends CaMetaObject {

    BigDecimal getQuantityToOrder();

    BigDecimal getQuantityToInvoice();

    BigDecimal getQuantityCancelled();
}
