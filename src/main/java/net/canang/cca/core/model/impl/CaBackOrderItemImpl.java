package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaBackOrderItem;

import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public class CaBackOrderItemImpl implements CaBackOrderItem {

    private Long id;
    private BigDecimal quantityToOrder;
    private BigDecimal quantityToInvoice;
    private BigDecimal quantityCancelled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getQuantityToOrder() {
        return quantityToOrder;
    }

    public void setQuantityToOrder(BigDecimal quantityToOrder) {
        this.quantityToOrder = quantityToOrder;
    }

    public BigDecimal getQuantityToInvoice() {
        return quantityToInvoice;
    }

    public void setQuantityToInvoice(BigDecimal quantityToInvoice) {
        this.quantityToInvoice = quantityToInvoice;
    }

    public BigDecimal getQuantityCancelled() {
        return quantityCancelled;
    }

    public void setQuantityCancelled(BigDecimal quantityCancelled) {
        this.quantityCancelled = quantityCancelled;
    }
}
