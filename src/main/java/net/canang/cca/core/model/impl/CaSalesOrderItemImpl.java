package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaSalesOrder;
import net.canang.cca.core.model.CaSalesOrderItem;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 5/29/13
 */
@Entity(name = "CaSalesOrderItem")
@Table(name = "CA_SALES_ORDER_ITEM")
public class CaSalesOrderItemImpl implements CaSalesOrderItem {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CA_SALES_ORDER_ITEM")
    @SequenceGenerator(name = "SEQ_CA_SALES_ORDER_ITEM", sequenceName = "SEQ_CA_SALES_ORDER_ITEM", allocationSize = 1)
    private Long id;

    @Column(name = "QUANTITY_TO_BACK_ORDER")
    private BigDecimal quantityToBackOrder;

    @Column(name = "QUANTITY_TO_INVOICE")
    private BigDecimal quantityToInvoice;

    @Column(name = "QUANTITY_FULFILLED")
    private BigDecimal quantityFulfilled;

    @Column(name = "QUANTITY_ALLOCATED")
    private BigDecimal quantityAllocated;

    @Column(name = "FULFILLED_DATE")
    private Date fulfilledDate;

    @Column(name = "SHIPPED_DATE")
    private Date shippedDate;

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

    public BigDecimal getQuantityToInvoice() {
        return quantityToInvoice;
    }

    public void setQuantityToInvoice(BigDecimal quantityToInvoice) {
        this.quantityToInvoice = quantityToInvoice;
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

    public CaSalesOrder getOrder() {
        return order;
    }

    public void setOrder(CaSalesOrder order) {
        this.order = order;
    }
}
