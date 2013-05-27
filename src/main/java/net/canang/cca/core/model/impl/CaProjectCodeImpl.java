package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaProjectCode;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 5/26/13
 */
@Entity(name = "CaProjectCode")
@Table(name="CA_PROJECT_CODE")
public class CaProjectCodeImpl implements CaProjectCode {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CA_PROJECT_CODE")
    @SequenceGenerator(name = "SEQ_CA_PROJECT_CODE", sequenceName = "SEQ_CA_PROJECT_CODE", allocationSize = 1)
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
