package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaPrincipal;
import net.canang.cca.core.model.CaPrincipalType;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
@Entity(name = "CaPrincipal")
@Table(name = "CA_PRINCIPAL")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CaPrincipalImpl implements CaPrincipal {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CA_PRINCIPAL")
    @SequenceGenerator(name = "SEQ_CA_PRINCIPAL", sequenceName = "SEQ_CA_PRINCIPAL", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

//    @Column(name = "ACTIVE")
//    private boolean active;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "PRINCIPAL_TYPE")
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

//    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }

    public CaPrincipalType getPrincipalType() {
        return principalType;
    }

    public void setPrincipalType(CaPrincipalType principalType) {
        this.principalType = principalType;
    }
}
