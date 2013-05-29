package net.canang.cca.core.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public interface CaSalesOrder extends CaDocument{

    BigDecimal getPaymentAmount();

    void setPaymentAmount(BigDecimal paymentAmount);

    BigDecimal getDepositAmount();

    void setDepositAmount(BigDecimal depositAmount);

    CaSalesOrderType getOrderType();

    void setOrderType(CaSalesOrderType orderType);

    CaShippingStatus getShippingStatus();

    void setShippingStatus(CaShippingStatus shippingStatus);

    CaWorkflowPriority getWorkflowPriority();

    void setWorkflowPriority(CaWorkflowPriority workflowPriority);

    List<CaSalesOrderItem> getItems();

    void setItems(List<CaSalesOrderItem> items);

//    List<CaSalesOrderPayment> getPayments();
//
//    void setPayments(List<CaSalesOrderPayment> payments);
}
