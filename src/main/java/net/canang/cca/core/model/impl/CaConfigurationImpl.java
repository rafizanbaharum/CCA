package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaConfiguration;

/**
 * @author rafizan.baharum
 * @since 5/26/13
 */

public class CaConfigurationImpl implements CaConfiguration {

    private Long id;
    private String key;
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
