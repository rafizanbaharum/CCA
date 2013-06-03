package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaSalesPerson;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
@Entity(name = "CaSalesperson")
@Table(name = "CA_SALESPERSON")
public class CaSalesPersonImpl extends CaConsumerImpl implements CaSalesPerson {
}
