package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaAccountCode;
import net.canang.cca.core.model.CaPostingType;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public class CaAccountCodeImpl implements CaAccountCode {

    private Long id;
    private String code;
    private String description;
    private String alias;
    private CaPostingType postingType;

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

    public CaPostingType getPostingType() {
        return postingType;
    }

    public void setPostingType(CaPostingType postingType) {
        this.postingType = postingType;
    }
}
