package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaUnitCode;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 5/29/13
 */
@Entity(name = "CaUnitCode")
@Table(name = "CA_UNIT_CODE")
public class CaUnitCodeImpl implements CaUnitCode {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CA_UNIT_CODE")
    @SequenceGenerator(name = "SEQ_CA_UNIT_CODE", sequenceName = "SEQ_CA_UNIT_CODE", allocationSize = 1)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ALIAS")
    private String alias;

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
}
