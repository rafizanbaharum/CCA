package net.canang.cca.biz.engine;

import net.canang.cca.core.model.CaPostable;

/**
 * @author rafizan.baharum
 * @since 5/28/13
 */
public interface InventoryManager {

    public void post(CaPostable postable);

    public void reverse(CaPostable postable);

}
