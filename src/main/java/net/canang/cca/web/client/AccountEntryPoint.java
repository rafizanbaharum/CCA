package net.canang.cca.web.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.gwtplatform.mvp.client.DelayedBindRegistry;
import net.canang.cca.web.client.gin.ClientGinjector;

/**
 * @author rafizan.baharum
 * @since 6/3/13
 */
public class AccountEntryPoint implements EntryPoint {

    public final ClientGinjector ginjector = GWT.create(ClientGinjector.class);

    @Override
    public void onModuleLoad() {
        DelayedBindRegistry.bind(ginjector);
        ginjector.getPlaceManager().revealCurrentPlace();
    }
}
