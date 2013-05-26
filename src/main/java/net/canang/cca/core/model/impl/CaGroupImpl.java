package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaPrincipal;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
@Entity(name = "CaGroup")
@Table(name="CA_GROUP")
public class CaGroupImpl extends CaPrincipalImpl implements CaPrincipal {
}
