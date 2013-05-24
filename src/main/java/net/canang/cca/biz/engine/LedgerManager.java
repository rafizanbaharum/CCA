package net.canang.cca.biz.engine;

import net.canang.cca.core.model.CaPostable;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface LedgerManager {

    public void post(CaPostable postable);

    public void reverse(CaPostable postable);
}
