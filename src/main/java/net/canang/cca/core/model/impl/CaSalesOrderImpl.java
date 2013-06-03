package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/29/13
 */
@Entity(name = "CaSalesOrder")
@Table(name = "CA_SALES_ORDER")
public class CaSalesOrderImpl extends CaDocumentImpl implements CaSalesOrder {

    @Column(name = "DEPOSIT_AMOUNT")
    private BigDecimal depositAmount;

    @Column(name = "PAYMENT_AMOUNT")
    private BigDecimal paymentAmount;

    @Column(name = "ORDER_TYPE")
    private CaSalesOrderType orderType;

    @Column(name = "SHIPPING_STATUS")
    private CaShippingStatus shippingStatus;

    @Column(name = "WORKFLOW_PRIORITY")
    private CaWorkflowPriority workflowPriority;

    @OneToOne(targetEntity = CaCustomerImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private CaCustomer customer;

    @OneToMany(targetEntity = CaSalesOrderItemImpl.class, mappedBy = "order", fetch = FetchType.LAZY)
    private List<CaSalesOrderItem> items;

//    @OneToMany(targetEntity = CaSalesOrderPaymentImpl.class, mappedBy = "order", fetch = FetchType.LAZY)
//    private List<CaSalesOrderPayment> payments;

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public CaSalesOrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(CaSalesOrderType orderType) {
        this.orderType = orderType;
    }

    public CaShippingStatus getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(CaShippingStatus shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public CaWorkflowPriority getWorkflowPriority() {
        return workflowPriority;
    }

    public void setWorkflowPriority(CaWorkflowPriority workflowPriority) {
        this.workflowPriority = workflowPriority;
    }

    public CaCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(CaCustomer customer) {
        this.customer = customer;
    }

    public List<CaSalesOrderItem> getItems() {
        return items;
    }

    public void setItems(List<CaSalesOrderItem> items) {
        this.items = items;
    }
}
