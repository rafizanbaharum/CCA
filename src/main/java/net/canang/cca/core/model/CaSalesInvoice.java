package net.canang.cca.core.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public interface CaSalesInvoice extends CaDocument {

    BigDecimal getPaymentAmount();

    void setPaymentAmount(BigDecimal paymentAmount);

    BigDecimal getDepositAmount();

    void setDepositAmount(BigDecimal depositAmount);

    CaWorkflowPriority getWorkflowPriority();

    void setWorkflowPriority(CaWorkflowPriority workflowPriority);

    List<CaSalesInvoiceItem> getItems();

    void setItems(List<CaSalesInvoiceItem> items);
}
