package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaVendor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 5/28/13
 */
@Entity(name = "CaVendor")
@Table(name = "CA_VENDOR")
public class CaVendorImpl extends CaConsumerImpl implements CaVendor {
}
