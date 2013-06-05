package net.canang.cca.web.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import net.canang.cca.web.client.AccountServiceAsync;
import net.canang.cca.web.client.presenter.*;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
@GinModules({Module.class})
public interface ClientGinjector extends Ginjector {

    PlaceManager getPlaceManager();

    Provider<RootPresenter> getRootPresenter();

    Provider<TopMenuPresenter> getTopMenuPresenter();

    Provider<SideMenuPresenter> getSideMenuPresenter();

    Provider<AccountHomePresenter> getAccountHomePresenter();

    Provider<AccountListPresenter> getAccountListPresenter();

    Provider<AccountViewPresenter> getAccountViewPresenter();

//
//    Provider<AccountConfigurePresenter> getAccountConfigurePresenter();

    EventBus getEventBus();

    AccountServiceAsync getAccountService();

}
