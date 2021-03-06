package net.canang.cca.core.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 5/28/13
 */
public interface CaSalesOrderItem extends CaMetaObject {

    BigDecimal getQuantityToBackOrder();

    void setQuantityToBackOrder(BigDecimal quantityToBackOrder);

    BigDecimal getQuantityToInvoice();

    void setQuantityToInvoice(BigDecimal quantityToInvoice);

    BigDecimal getQuantityFulfilled();

    void setQuantityFulfilled(BigDecimal quantityFulfilled);

    BigDecimal getQuantityAllocated();

    void setQuantityAllocated(BigDecimal quantityAllocated);

    Date getFulfilledDate();

    void setFulfilledDate(Date fulfilledDate);

    Date getShippedDate();

    void setShippedDate(Date shippedDate);

    CaSalesOrder getOrder();

    void setOrder(CaSalesOrder salesOrder);

    // components
    // lots
    // bins

}
