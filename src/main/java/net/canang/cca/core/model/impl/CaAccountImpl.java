package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.*;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public class CaAccountImpl implements CaAccount {

    private Long id;
    private String code;
    private String description;
    private String alias;
    private CaBalanceType balanceType;
    private CaPostingType postingType;
    private CaLocationCode locationCode;
    private CaAccountCode accountCode;
    private CaProjectCode projectCode;

    private List<CaAccountPostingLevel> postingLevels;
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

    public CaLocationCode getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(CaLocationCode locationCode) {
        this.locationCode = locationCode;
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
