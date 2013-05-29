package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/28/13
 */
@Entity(name = "CaPurchaseInvoice")
@Table(name = "CA_PURCHASE_INVOICE_ITEM")
public class CaPurchaseInvoiceItemImpl implements CaPurchaseInvoiceItem {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CA_PURCHASE_INVOICE_ITEM")
    @SequenceGenerator(name = "SEQ_CA_PURCHASE_INVOICE_ITEM", sequenceName = "SEQ_CA_PURCHASE_INVOICE_ITEM", allocationSize = 1)
    private Long id;

    @Column(name = "UNIT_COST")
    private BigDecimal unitCost;

    @Column(name = "EXTENDED_COST")
    private BigDecimal extendedCost;

    @Column(name = "QUANTITY_ORDERED")
    private BigDecimal quantityOrdered;

    @Column(name = "QUANTITY_SHIPPED")
    private BigDecimal quantityShipped;

    @ManyToOne(targetEntity = CaUnitCodeImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "UNIT_CODE_ID")
    private CaUnitCode unitCode;

    @ManyToOne(targetEntity = CaItemImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private CaItem item;

    @ManyToOne(targetEntity = CaSiteCodeImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "SITE_CODE_ID")
    private CaSiteCode siteCode;

    @ManyToOne(targetEntity = CaPurchaseInvoiceImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICE_ID")
    private CaPurchaseInvoice invoice;

    @ManyToOne(targetEntity = CaPurchaseOrderImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private CaPurchaseOrder order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CaItem getItem() {
        return item;
    }

    public void setItem(CaItem item) {
        this.item = item;
    }

    public CaSiteCode getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(CaSiteCode siteCode) {
        this.siteCode = siteCode;
    }

    public CaUnitCode getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(CaUnitCode unitCode) {
        this.unitCode = unitCode;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public BigDecimal getExtendedCost() {
        return extendedCost;
    }

    public void setExtendedCost(BigDecimal extendedCost) {
        this.extendedCost = extendedCost;
    }

    public BigDecimal getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(BigDecimal quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public BigDecimal getQuantityShipped() {
        return quantityShipped;
    }

    public void setQuantityShipped(BigDecimal quantityShipped) {
        this.quantityShipped = quantityShipped;
    }

    public CaPurchaseOrder getOrder() {
        return order;
    }

    public void setOrder(CaPurchaseOrder order) {
        this.order = order;
    }

    public CaPurchaseInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(CaPurchaseInvoice invoice) {
        this.invoice = invoice;
    }
}
