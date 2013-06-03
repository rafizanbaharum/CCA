package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaItem;
import net.canang.cca.core.model.CaItemPrice;
import net.canang.cca.core.model.CaUnitCode;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/29/13
 */
@Entity(name = "CaItemPrice")
@Table(name = "CA_ITEM_PRICE")
public class CaItemPriceImpl implements CaItemPrice {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CA_ITEM_PRICE")
    @SequenceGenerator(name = "SEQ_CA_ITEM_PRICE", sequenceName = "SEQ_CA_ITEM_PRICE", allocationSize = 1)
    private Long id;

    @Column(name = "PERCENT")
    private BigDecimal percent;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "START_QUANTITY")
    private BigDecimal startQuantity;

    @Column(name = "END_QUANTITY")
    private BigDecimal endQuantity;

    @ManyToOne(targetEntity = CaItemImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private CaItem item;

    @ManyToOne(targetEntity = CaUnitCodeImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "UNIT_CODE_ID")
    private CaUnitCode unitCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getStartQuantity() {
        return startQuantity;
    }

    public void setStartQuantity(BigDecimal startQuantity) {
        this.startQuantity = startQuantity;
    }

    public BigDecimal getEndQuantity() {
        return endQuantity;
    }

    public void setEndQuantity(BigDecimal endQuantity) {
        this.endQuantity = endQuantity;
    }

    public CaItem getItem() {
        return item;
    }

    public void setItem(CaItem item) {
        this.item = item;
    }

    public CaUnitCode getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(CaUnitCode unitCode) {
        this.unitCode = unitCode;
    }
}
