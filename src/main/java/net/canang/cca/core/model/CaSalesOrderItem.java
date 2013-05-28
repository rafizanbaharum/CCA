package net.canang.cca.core.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 5/28/13
 */
public interface CaSalesOrderItem {

    BigDecimal getQuantityToBackOrder();

    BigDecimal getQuantityToInvoice();

    BigDecimal getQuantityFulfilled();

    BigDecimal getQuantityAllocated();

    Date getFulfilledDate();

    Date getShippedDate();

    // components
    // lots
    // bins

}
