package net.canang.cca.web.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import net.canang.cca.web.client.AccountServiceAsync;
import net.canang.cca.web.client.presenter.MainPagePresenter;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
@GinModules({MyModule.class})
public interface ClientGinjector extends Ginjector {

    PlaceManager getPlaceManager();

    Provider<MainPagePresenter> getMainPagePresenter();

    EventBus getEventBus();

    AccountServiceAsync getAccountService();

}
