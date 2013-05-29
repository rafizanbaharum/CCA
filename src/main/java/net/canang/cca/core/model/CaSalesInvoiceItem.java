package net.canang.cca.core.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 5/29/13
 */
public interface CaSalesInvoiceItem {

    BigDecimal getQuantityToBackOrder();

    void setQuantityToBackOrder(BigDecimal quantityToBackOrder);

    BigDecimal getQuantityBilled();

    void setQuantityBilled(BigDecimal quantityBilled);

    BigDecimal getQuantityFulfilled();

    void setQuantityFulfilled(BigDecimal quantityFulfilled);

    BigDecimal getQuantityAllocated();

    void setQuantityAllocated(BigDecimal quantityAllocated);

    Date getFulfilledDate();

    void setFulfilledDate(Date fulfilledDate);

    Date getShippedDate();

    void setShippedDate(Date shippedDate);

    CaSalesInvoice getInvoice();

    void setInvoice(CaSalesInvoice invoice);

    CaSalesOrder getOrder();

    void setOrder(CaSalesOrder order);

    // components
    // lots
    // bins


}
