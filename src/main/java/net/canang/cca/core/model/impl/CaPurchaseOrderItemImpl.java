package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/28/13
 */
@Entity(name = "CaPurchaseOrder")
@Table(name = "CA_PURCHASE_ORDER_ITEM")
public class CaPurchaseOrderItemImpl implements CaPurchaseOrderItem {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CA_PURCHASE_ORDER_ITEM")
    @SequenceGenerator(name = "SEQ_CA_PURCHASE_ORDER_ITEM", sequenceName = "SEQ_CA_PURCHASE_ORDER_ITEM", allocationSize = 1)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "UNIT_COST")
    private BigDecimal unitCost;

    @Column(name = "EXTENDED_COST")
    private BigDecimal extendedCost;

    @Column(name = "QUANTITY_ORDERED")
    private BigDecimal quantityOrdered;

    @Column(name = "QUANTITY_CANCELLED")
    private BigDecimal quantityCancelled;

    @JoinColumn(name = "UNIT_CODE_ID")
    private CaUnitCode unitCode;

    @JoinColumn(name = "ITEM_ID")
    private CaItem item;

    @JoinColumn(name = "SITE_ID")
    private CaSite site;

    @JoinColumn(name = "ORDER_ID")
    private CaPurchaseOrder order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CaItem getItem() {
        return item;
    }

    public void setItem(CaItem item) {
        this.item = item;
    }

    public CaSite getSite() {
        return site;
    }

    public void setSite(CaSite site) {
        this.site = site;
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

    public BigDecimal getQuantityCancelled() {
        return quantityCancelled;
    }

    public void setQuantityCancelled(BigDecimal quantityCancelled) {
        this.quantityCancelled = quantityCancelled;
    }

    public CaPurchaseOrder getOrder() {
        return order;
    }

    public void setOrder(CaPurchaseOrder order) {
        this.order = order;
    }
}
