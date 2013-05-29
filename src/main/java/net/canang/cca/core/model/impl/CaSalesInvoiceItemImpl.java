package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaSalesInvoice;
import net.canang.cca.core.model.CaSalesInvoiceItem;
import net.canang.cca.core.model.CaSalesOrder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 5/29/13
 */
@Entity(name = "CaSalesInvoiceItem")
@Table(name = "CA_SALES_INVOICE_ITEM")
public class CaSalesInvoiceItemImpl implements CaSalesInvoiceItem {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CA_SALES_INVOICE_ITEM")
    @SequenceGenerator(name = "SEQ_CA_SALES_INVOICE_ITEM", sequenceName = "SEQ_CA_SALES_INVOICE_ITEM", allocationSize = 1)
    private Long id;

    @Column(name = "QUANTITY_TO_BACK_ORDER")
    private BigDecimal quantityToBackOrder;

    @Column(name = "QUANTITY_TO_BILLED")
    private BigDecimal quantityBilled;

    @Column(name = "QUANTITY_FULFILLED")
    private BigDecimal quantityFulfilled;

    @Column(name = "QUANTITY_ALLOCATED")
    private BigDecimal quantityAllocated;

    @Column(name = "FULFILLED_DATE")
    private Date fulfilledDate;

    @Column(name = "SHIPPED_DATE")
    private Date shippedDate;

    @ManyToOne(targetEntity = CaSalesInvoiceImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICE_ID")
    private CaSalesInvoice invoice;

    @ManyToOne(targetEntity = CaSalesOrderImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private CaSalesOrder order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getQuantityToBackOrder() {
        return quantityToBackOrder;
    }

    public void setQuantityToBackOrder(BigDecimal quantityToBackOrder) {
        this.quantityToBackOrder = quantityToBackOrder;
    }

    public BigDecimal getQuantityBilled() {
        return quantityBilled;
    }

    public void setQuantityBilled(BigDecimal quantityBilled) {
        this.quantityBilled = quantityBilled;
    }

    public BigDecimal getQuantityFulfilled() {
        return quantityFulfilled;
    }

    public void setQuantityFulfilled(BigDecimal quantityFulfilled) {
        this.quantityFulfilled = quantityFulfilled;
    }

    public BigDecimal getQuantityAllocated() {
        return quantityAllocated;
    }

    public void setQuantityAllocated(BigDecimal quantityAllocated) {
        this.quantityAllocated = quantityAllocated;
    }

    public Date getFulfilledDate() {
        return fulfilledDate;
    }

    public void setFulfilledDate(Date fulfilledDate) {
        this.fulfilledDate = fulfilledDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public CaSalesInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(CaSalesInvoice invoice) {
        this.invoice = invoice;
    }

    public CaSalesOrder getOrder() {
        return order;
    }

    public void setOrder(CaSalesOrder order) {
        this.order = order;
    }
}
