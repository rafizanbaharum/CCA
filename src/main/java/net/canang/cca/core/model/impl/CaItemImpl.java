package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public class CaItemImpl implements CaItem {

    private Long id;
    private String code;
    private String description;
    private String shortDescription;
    private String genericDescription;
    private String alias;

    private boolean allowBackOrder;
    private CaTaxType purchaseTaxType;
    private CaTaxType salesTaxType;
    private CaUnitCode unitCode;

    private BigDecimal standardCost;
    private BigDecimal currentCost;

    private CaItemPriceMethod priceMethod;
    private CaItemPriceLevel defaultPriceLevel;
    private List<CaItemPriceLevel> priceLevels;


    private BigDecimal quantityAvailable;
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

    public CaTaxType getPurchaseTaxType() {
        return purchaseTaxType;
    }

    public void setPurchaseTaxType(CaTaxType purchaseTaxType) {
        this.purchaseTaxType = purchaseTaxType;
    }

    public CaTaxType getSalesTaxType() {
        return salesTaxType;
    }

    public void setSalesTaxType(CaTaxType salesTaxType) {
        this.salesTaxType = salesTaxType;
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

    public CaItemPriceLevel getDefaultPriceLevel() {
        return defaultPriceLevel;
    }

    public void setDefaultPriceLevel(CaItemPriceLevel defaultPriceLevel) {
        this.defaultPriceLevel = defaultPriceLevel;
    }

    public List<CaItemPriceLevel> getPriceLevels() {
        return priceLevels;
    }

    public void setPriceLevels(List<CaItemPriceLevel> priceLevels) {
        this.priceLevels = priceLevels;
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
