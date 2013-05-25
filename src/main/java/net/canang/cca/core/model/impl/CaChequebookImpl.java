package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaAccount;
import net.canang.cca.core.model.CaBank;
import net.canang.cca.core.model.CaChequebook;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public class CaChequebookImpl implements CaChequebook {

    private Long id;
    private String code;
    private String description;
    private String alias;
    private Date reconciliationDate;
    private Integer nextChequeNo;
    private CaAccount account;
    private CaBank bank;

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

    public Integer getNextChequeNo() {
        return nextChequeNo;
    }

    public void setNextChequeNo(Integer nextChequeNo) {
        this.nextChequeNo = nextChequeNo;
    }

    public Date getReconciliationDate() {
        return reconciliationDate;
    }

    public void setReconciliationDate(Date reconciliationDate) {
        this.reconciliationDate = reconciliationDate;
    }

    public CaAccount getAccount() {
        return account;
    }

    public void setAccount(CaAccount account) {
        this.account = account;
    }

    public CaBank getBank() {
        return bank;
    }

    public void setBank(CaBank bank) {
        this.bank = bank;
    }
}
