package net.canang.cca.core.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 5/28/13
 */
public interface CaSalesOrderPayment {

    boolean isProcessElectronically();

    Date getPaymentDate();

    BigDecimal getPaymentAmount();

}
