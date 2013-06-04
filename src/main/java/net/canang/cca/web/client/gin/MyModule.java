package net.canang.cca.web.client.gin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import net.canang.cca.web.client.AccountService;
import net.canang.cca.web.client.AccountServiceAsync;
import net.canang.cca.web.client.place.MyPlaceManager;
import net.canang.cca.web.client.presenter.MainPagePresenter;
import net.canang.cca.web.client.view.MainPageView;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class MyModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        install(new DefaultModule(MyPlaceManager.class));


        // Presenters
        bindPresenter(MainPagePresenter.class,
                MainPagePresenter.MyView.class,
                MainPageView.class,
                MainPagePresenter.MyProxy.class);
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
