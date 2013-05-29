package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
@Entity(name = "CaAccount")
@Table(name = "CA_ACCOUNT")
public class CaAccountImpl implements CaAccount {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CA_ACCOUNT")
    @SequenceGenerator(name = "SEQ_CA_ACCOUNT", sequenceName = "SEQ_CA_ACCOUNT", allocationSize = 1)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ALIAS")
    private String alias;

    @Column(name = "BALANCE_TYPE")
    private CaBalanceType balanceType;

    @Column(name = "POSTING_TYPE")
    private CaPostingType postingType;

    @Column(name = "ACCOUNT_TYPE")
    private CaAccountType accountType;

    @ManyToOne(targetEntity = CaDepartmentCodeImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCATION_CODE_ID")
    private CaDepartmentCode departmentCode;

    @ManyToOne(targetEntity = CaAccountCodeImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_CODE_ID")
    private CaAccountCode accountCode;

    @ManyToOne(targetEntity = CaProjectCodeImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_CODE_ID")
    private CaProjectCode projectCode;

    @Transient //TODO: for now
    private List<CaAccountPostingLevel> postingLevels;

    @Transient //TODO: for now
    private List<CaAccountPostingLookup> postingLookups;

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

    public CaBalanceType getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(CaBalanceType balanceType) {
        this.balanceType = balanceType;
    }

    public CaPostingType getPostingType() {
        return postingType;
    }

    public void setPostingType(CaPostingType postingType) {
        this.postingType = postingType;
    }

    public CaAccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(CaAccountType accountType) {
        this.accountType = accountType;
    }

    public CaDepartmentCode getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(CaDepartmentCode departmentCode) {
        this.departmentCode = departmentCode;
    }

    public CaAccountCode getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(CaAccountCode accountCode) {
        this.accountCode = accountCode;
    }

    public CaProjectCode getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(CaProjectCode projectCode) {
        this.projectCode = projectCode;
    }

    public List<CaAccountPostingLevel> getPostingLevels() {
        return postingLevels;
    }

    public void setPostingLevels(List<CaAccountPostingLevel> postingLevels) {
        this.postingLevels = postingLevels;
    }

    public List<CaAccountPostingLookup> getPostingLookups() {
        return postingLookups;
    }

    public void setPostingLookups(List<CaAccountPostingLookup> postingLookups) {
        this.postingLookups = postingLookups;
    }
}
