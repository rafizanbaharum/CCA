package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaAccount;
import net.canang.cca.core.model.CaAccountPostingLevel;
import net.canang.cca.core.model.CaPostingLevel;
import net.canang.cca.core.model.CaSeries;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public class CaAccountPostingLevelImpl implements CaAccountPostingLevel {

    private Long id;
    private CaAccount account;
    private CaSeries series;
    private CaPostingLevel postingLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CaAccount getAccount() {
        return account;
    }

    public void setAccount(CaAccount account) {
        this.account = account;
    }

    public CaSeries getSeries() {
        return series;
    }

    public void setSeries(CaSeries series) {
        this.series = series;
    }

    public CaPostingLevel getPostingLevel() {
        return postingLevel;
    }

    public void setPostingLevel(CaPostingLevel postingLevel) {
        this.postingLevel = postingLevel;
    }
}
