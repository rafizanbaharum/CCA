package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class CaReceiptImpl extends CaDocumentImpl implements CaReceipt {

    private BigDecimal amount;
    private CaPaymentType paymentType;
    private CaCustomer customer;
    private CaBatchReceipt batch;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CaPaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(CaPaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public CaCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(CaCustomer customer) {
        this.customer = customer;
    }

    public CaBatchReceipt getBatch() {
        return batch;
    }

    public void setBatch(CaBatchReceipt batch) {
        this.batch = batch;
    }
}
