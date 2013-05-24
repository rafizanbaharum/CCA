package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaPrincipal;
import net.canang.cca.core.model.CaPrincipalType;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public abstract class CaPrincipalImpl implements CaPrincipal {

    private Long id;
    private String name;
    private boolean active;
    private CaPrincipalType principalType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CaPrincipalType getPrincipalType() {
        return principalType;
    }

    public void setPrincipalType(CaPrincipalType principalType) {
        this.principalType = principalType;
    }
}
