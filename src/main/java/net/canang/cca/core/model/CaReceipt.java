package net.canang.cca.core.model;

import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaReceipt extends CaDocument{

    BigDecimal getAmount();

    void setAmount(BigDecimal amount);

    CaPaymentType getPaymentType();

    void setPaymentType(CaPaymentType paymentType);

    CaCustomer getCustomer();

    void setCustomer(CaCustomer customer);

    CaBatchReceipt getBatch();

    void setBatch(CaBatchReceipt batch);
}
