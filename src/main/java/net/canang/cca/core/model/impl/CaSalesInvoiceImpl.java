package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaCustomer;
import net.canang.cca.core.model.CaSalesInvoice;
import net.canang.cca.core.model.CaSalesInvoiceItem;
import net.canang.cca.core.model.CaWorkflowPriority;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/29/13
 */
@Entity(name = "CaSalesInvoice")
@Table(name = "CA_SALES_INVOICE")
public class CaSalesInvoiceImpl extends CaDocumentImpl implements CaSalesInvoice {

    @Column(name = "DEPOSIT_AMOUNT")
    private BigDecimal depositAmount;

    @Column(name = "PAYMENT_AMOUNT")
    private BigDecimal paymentAmount;

    @Column(name = "INVOICE_TYPE")
    private CaSalesInvoiceType invoiceType;

    @Column(name = "WORKFLOW_PRIORITY")
    private CaWorkflowPriority workflowPriority;

    @OneToOne(targetEntity = CaCustomerImpl.class, fetch = FetchType.LAZY)
    @Column(name = "CUSTOMER_ID")
    private CaCustomer customer;

    @OneToMany(targetEntity = CaSalesInvoiceItemImpl.class, mappedBy = "invoice", fetch = FetchType.LAZY)
    private List<CaSalesInvoiceItem> items;

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

    public CaSalesInvoiceType getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(CaSalesInvoiceType invoiceType) {
        this.invoiceType = invoiceType;
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

    public List<CaSalesInvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<CaSalesInvoiceItem> items) {
        this.items = items;
    }
}
