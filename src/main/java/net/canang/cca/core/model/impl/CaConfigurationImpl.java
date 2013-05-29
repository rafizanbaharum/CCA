package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaConfiguration;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 5/26/13
 */

@Entity(name = "CaConfiguration")
@Table(name = "CA_CONFIGURATION")
public class CaConfigurationImpl implements CaConfiguration {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CA_CONFIGURATION")
    @SequenceGenerator(name = "SEQ_CA_CONFIGURATION", sequenceName = "SEQ_CA_CONFIGURATION", allocationSize = 1)
    private Long id;

    @Column(name = "CONFIG_KEY")
    private String key;

    @Column(name = "CONFIG_VALUE")
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
