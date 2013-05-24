package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.*;
import net.canang.cca.core.model.CaJournal;
import net.canang.cca.core.model.CaCompany;

import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class CaPostingImpl implements CaPosting {

    private Long id;
    private String description;
    private BigDecimal amount;
    private CaCompany company;
    private CaAccount account;
    private CaJournal journal;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CaCompany getCompany() {
        return company;
    }

    public void setCompany(CaCompany company) {
        this.company = company;
    }

    public CaAccount getAccount() {
        return account;
    }

    public void setAccount(CaAccount account) {
        this.account = account;
    }

    public CaJournal getJournal() {
        return journal;
    }

    public void setJournal(CaJournal journal) {
        this.journal = journal;
    }
}
