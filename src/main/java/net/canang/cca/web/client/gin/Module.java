package net.canang.cca.web.client.gin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import net.canang.cca.web.client.AccountService;
import net.canang.cca.web.client.AccountServiceAsync;
import net.canang.cca.web.client.place.ModulePlaceManager;
import net.canang.cca.web.client.presenter.*;
import net.canang.cca.web.client.view.*;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class Module extends AbstractPresenterModule {

    @Override
    protected void configure() {
        install(new DefaultModule(ModulePlaceManager.class));

        bindPresenter(RootPresenter.class,
                RootPresenter.MyView.class,
                RootView.class,
                RootPresenter.MyProxy.class);

        bindPresenter(TopMenuPresenter.class,
                TopMenuPresenter.MyView.class,
                TopMenuView.class,
                TopMenuPresenter.MyProxy.class);

        bindPresenter(SideMenuPresenter.class,
                SideMenuPresenter.MyView.class,
                SideMenuView.class,
                SideMenuPresenter.MyProxy.class);

        bindPresenter(AccountHomePresenter.class,
                AccountHomePresenter.MyView.class,
                AccountHomeView.class,
                AccountHomePresenter.MyProxy.class);

        bindPresenter(AccountListPresenter.class,
                AccountListPresenter.MyView.class,
                AccountListView.class,
                AccountListPresenter.MyProxy.class);
//
//        bindPresenter(AccountConfigurePresenter.class,
//                AccountConfigurePresenter.MyView.class,
//                AccountConfigureView.class,
//                AccountConfigurePresenter.MyProxy.class);
    }


    @Provides
    @Singleton
    public AccountServiceAsync createAccountService() {
        AccountServiceAsync service = GWT.create(AccountService.class);
        ServiceDefTarget accountEndpoint = (ServiceDefTarget) service;
        accountEndpoint.setServiceEntryPoint(com.google.gwt.core.client.GWT.getModuleBaseURL() + "AccountService");
        return service;
    }
}
