package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaAccount;
import net.canang.cca.core.model.CaJournal;
import net.canang.cca.core.model.CaPosting;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
@Entity(name = "CaPosting")
@Table(name = "CA_POSTING")
public class CaPostingImpl implements CaPosting {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CA_POSTING")
    @SequenceGenerator(name = "SEQ_CA_POSTING", sequenceName = "SEQ_CA_POSTING", allocationSize = 1)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    // TODO:company
//    private CaCompany company;

    @ManyToOne(targetEntity = CaAccountImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private CaAccount account;

    @ManyToOne(targetEntity = CaJournalImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "JOURNAL_ID")
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

    // TODO: company
//    public CaCompany getCompany() {
//        return company;
//    }
//
//    public void setCompany(CaCompany company) {
//        this.company = company;
//    }

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
