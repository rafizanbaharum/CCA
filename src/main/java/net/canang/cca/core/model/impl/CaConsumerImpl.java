package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaAccount;
import net.canang.cca.core.model.CaChequebook;
import net.canang.cca.core.model.CaConsumer;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class CaConsumerImpl implements CaConsumer {

    private Long id;
    private String code;
    private String name;
    private String statementName;
    private String description;
    private String alias;
    private String primaryPhone;
    private String secondaryPhone;
    private String primaryEmail;
    private String secondaryEmail;
    private String address;
    private CaChequebook chequebook;
    private CaAccount inventoryAccount;
    private CaAccount receivableAccount;
    private CaAccount salesAccount;
    private CaAccount cashAccount;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatementName() {
        return statementName;
    }

    public void setStatementName(String statementName) {
        this.statementName = statementName;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CaChequebook getChequebook() {
        return chequebook;
    }

    public void setChequebook(CaChequebook chequebook) {
        this.chequebook = chequebook;
    }

    public CaAccount getInventoryAccount() {
        return inventoryAccount;
    }

    public void setInventoryAccount(CaAccount inventoryAccount) {
        this.inventoryAccount = inventoryAccount;
    }

    public CaAccount getReceivableAccount() {
        return receivableAccount;
    }

    public void setReceivableAccount(CaAccount receivableAccount) {
        this.receivableAccount = receivableAccount;
    }

    public CaAccount getSalesAccount() {
        return salesAccount;
    }

    public void setSalesAccount(CaAccount salesAccount) {
        this.salesAccount = salesAccount;
    }

    public CaAccount getCashAccount() {
        return cashAccount;
    }

    public void setCashAccount(CaAccount cashAccount) {
        this.cashAccount = cashAccount;
    }
}
