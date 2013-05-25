package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaInvoice;
import net.canang.cca.core.model.CaInvoiceItem;
import net.canang.cca.core.model.CaInvoiceItemMarkdownInfo;
import net.canang.cca.core.model.CaItemCode;

import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class CaInvoiceItemImpl implements CaInvoiceItem {

    private Long id;
    private String description;
    private CaItemCode itemCode;
    private BigDecimal quantity;
    private BigDecimal unitCost;
    private BigDecimal unitPrice;
    private boolean markdowned;
    private CaInvoice invoice;
    private CaInvoiceItemMarkdownInfo markdownInfo; // NOTE: embedded

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

    public CaItemCode getItemCode() {
        return itemCode;
    }

    public void setItemCode(CaItemCode itemCode) {
        this.itemCode = itemCode;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isMarkdowned() {
        return markdowned;
    }

    public void setMarkdowned(boolean markdowned) {
        this.markdowned = markdowned;
    }

    public CaInvoiceItemMarkdownInfo getMarkdownInfo() {
        return markdownInfo;
    }

    public void setMarkdownInfo(CaInvoiceItemMarkdownInfo markdownInfo) {
        this.markdownInfo = markdownInfo;
    }

    public CaInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(CaInvoice invoice) {
        this.invoice = invoice;
    }
}
