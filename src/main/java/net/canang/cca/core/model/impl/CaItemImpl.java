package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
@Entity(name = "CaItem")
@Table(name = "CA_ITEM")
public class CaItemImpl implements CaItem {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CA_ITEM")
    @SequenceGenerator(name = "SEQ_CA_ITEM", sequenceName = "SEQ_CA_ITEM", allocationSize = 1)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SHORT_DESCRIPTION")
    private String shortDescription;

    @Column(name = "GENERIC_DESCRIPTION")
    private String genericDescription;

    @Column(name = "ALIAS")
    private String alias;

    @Column(name = "ALLOW_BACK_ORDER")
    private boolean allowBackOrder;

    @Column(name = "AP_TAX_TYPE")
    private CaTaxType apTaxType;

    @Column(name = "AR_TAX_TYPE")
    private CaTaxType arTaxType;

    @Column(name = "STANDARD_COST")
    private BigDecimal standardCost;

    @Column(name = "CURRENT_COST")
    private BigDecimal currentCost;

    @Column(name = "PRICE_METHOD")
    private CaItemPriceMethod priceMethod;

    @ManyToOne(targetEntity = CaItemPriceImpl.class, fetch = FetchType.LAZY)
    @Column(name = "DEFAULT_PRICE_LEVEL")
    private CaItemPrice defaultPrice;

    @ManyToOne(targetEntity = CaUnitCodeImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "UNIT_CODE_ID")
    private CaUnitCode unitCode;

    @ManyToOne(targetEntity = CaAccountImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "UNIT_ACCOUNT_ID")
    private CaAccount unitAccount;

    @OneToMany(targetEntity = CaItemPriceImpl.class, mappedBy = "item", fetch = FetchType.LAZY)
    private List<CaItemPrice> prices;

    @Transient
    private BigDecimal quantityAvailable;

    @Transient
    private BigDecimal quantityOnHand;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getGenericDescription() {
        return genericDescription;
    }

    public void setGenericDescription(String genericDescription) {
        this.genericDescription = genericDescription;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public boolean isAllowBackOrder() {
        return allowBackOrder;
    }

    public void setAllowBackOrder(boolean allowBackOrder) {
        this.allowBackOrder = allowBackOrder;
    }

    public CaTaxType getApTaxType() {
        return apTaxType;
    }

    public void setApTaxType(CaTaxType apTaxType) {
        this.apTaxType = apTaxType;
    }

    public CaTaxType getArTaxType() {
        return arTaxType;
    }

    public void setArTaxType(CaTaxType arTaxType) {
        this.arTaxType = arTaxType;
    }

    public CaUnitCode getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(CaUnitCode unitCode) {
        this.unitCode = unitCode;
    }

    public BigDecimal getStandardCost() {
        return standardCost;
    }

    public void setStandardCost(BigDecimal standardCost) {
        this.standardCost = standardCost;
    }

    public BigDecimal getCurrentCost() {
        return currentCost;
    }

    public void setCurrentCost(BigDecimal currentCost) {
        this.currentCost = currentCost;
    }

    public CaItemPriceMethod getPriceMethod() {
        return priceMethod;
    }

    public void setPriceMethod(CaItemPriceMethod priceMethod) {
        this.priceMethod = priceMethod;
    }

    public CaItemPrice getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(CaItemPrice defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public CaAccount getUnitAccount() {
        return unitAccount;
    }

    public void setUnitAccount(CaAccount unitAccount) {
        this.unitAccount = unitAccount;
    }

    public List<CaItemPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<CaItemPrice> prices) {
        this.prices = prices;
    }

    public BigDecimal getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(BigDecimal quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public BigDecimal getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(BigDecimal quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }
}
