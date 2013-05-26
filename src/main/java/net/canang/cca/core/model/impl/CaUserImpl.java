package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaUser;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
@Entity(name = "CaUser")
@Table(name="CA_USER")
public class CaUserImpl extends CaPrincipalImpl implements CaUser {

    @Override
    public String getUsername() {
        return getName();
    }
}
