package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaCustomer;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
@Entity(name = "CaCustomer")
@Table(name = "CA_CUSTOMER")
public class CaCustomerImpl extends CaConsumerImpl implements CaCustomer {
}
