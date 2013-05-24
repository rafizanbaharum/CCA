package net.canang.cca.core.model;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaPrincipal extends CaMetaObject {

    String getName();

    void setName(String name);

    CaPrincipalType getPrincipalType();

    void setPrincipalType(CaPrincipalType principalType);

    boolean isActive();

    void setActive(boolean active);

}
