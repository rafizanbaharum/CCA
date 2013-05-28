package net.canang.cca.core.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public interface CaSalesOrder extends CaDocument{

    BigDecimal getPaymentAmount();

    BigDecimal getDepositAmount();

    CaShippingStatus getShippingStatus();

    CaWorkflowPriority getWorkflowPriority();

    List<CaSalesOrderItem> getItems();

    List<CaSalesOrderPayment> getPayments();
}
