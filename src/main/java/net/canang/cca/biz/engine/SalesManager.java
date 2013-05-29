package net.canang.cca.biz.engine;

import net.canang.cca.core.model.CaPostable;
import net.canang.cca.core.model.CaSalesInvoice;
import net.canang.cca.core.model.CaSalesOrder;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface SalesManager {

    CaSalesInvoice applyToSalesInvoice(CaSalesOrder salesOrder);

    void post(CaPostable postable);

    void reverse(CaPostable postable);
}
