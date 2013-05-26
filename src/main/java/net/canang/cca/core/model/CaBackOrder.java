package net.canang.cca.core.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public interface CaBackOrder {

    BigDecimal getPaymentAmount();

    BigDecimal getDepositAmount();

    List<CaBackOrderItem> getItems();
}
