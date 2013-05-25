package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaAccount;
import net.canang.cca.core.model.CaItemCode;
import net.canang.cca.core.model.CaTaxType;
import net.canang.cca.core.model.CaUnitCode;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public class CaItemCodeImpl implements CaItemCode {

    private Long id;
    private String code;
    private String description;
    private String alias;

    private boolean allowBackOrder;
    private CaTaxType purchaseTaxType;
    private CaTaxType salesTaxType;
    private CaUnitCode unitCode;

    private CaAccount salesAccount;
    private CaAccount cogsAccount;
    private CaAccount markdownAccount;
    private CaAccount inventoryAccount;
    private CaAccount inventoryOffsetAccount;
    private CaAccount salesReturnAccount;
    private CaAccount inventoryReturnAccount;


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


    public CaAccount getSalesAccount() {
        return salesAccount;
    }

    public void setSalesAccount(CaAccount salesAccount) {
        this.salesAccount = salesAccount;
    }

    public CaAccount getCogsAccount() {
        return cogsAccount;
    }

    public void setCogsAccount(CaAccount cogsAccount) {
        this.cogsAccount = cogsAccount;
    }

    public CaAccount getInventoryAccount() {
        return inventoryAccount;
    }

    public void setInventoryAccount(CaAccount inventoryAccount) {
        this.inventoryAccount = inventoryAccount;
    }

    public CaAccount getMarkdownAccount() {
        return markdownAccount;
    }

    public void setMarkdownAccount(CaAccount markdownAccount) {
        this.markdownAccount = markdownAccount;
    }

    public CaAccount getInventoryOffsetAccount() {
        return inventoryOffsetAccount;
    }

    public void setInventoryOffsetAccount(CaAccount inventoryOffsetAccount) {
        this.inventoryOffsetAccount = inventoryOffsetAccount;
    }

    public CaAccount getSalesReturnAccount() {
        return salesReturnAccount;
    }

    public void setSalesReturnAccount(CaAccount salesReturnAccount) {
        this.salesReturnAccount = salesReturnAccount;
    }

    public CaAccount getInventoryReturnAccount() {
        return inventoryReturnAccount;
    }

    public void setInventoryReturnAccount(CaAccount inventoryReturnAccount) {
        this.inventoryReturnAccount = inventoryReturnAccount;
    }
}
