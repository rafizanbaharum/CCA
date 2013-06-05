package net.canang.cca.web.client.presenter;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import net.canang.cca.web.client.AccountServiceAsync;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class SideMenuPresenter extends Presenter<SideMenuPresenter.MyView, SideMenuPresenter.MyProxy> implements SideMenuUiHandlers {

    private PlaceManager placeManager;

    private AccountServiceAsync service;

    public interface MyView extends View, HasUiHandlers<SideMenuUiHandlers> {
    }

    @ProxyStandard
    @NameToken(ModuleNameTokens.SIDEMENU)
    public interface MyProxy extends ProxyPlace<SideMenuPresenter> {
    }

    @Inject
    public SideMenuPresenter(Provider<AccountServiceAsync> provider, EventBus eventBus, MyView view, MyProxy proxy,
                             PlaceManager placeManager
    ) {
        super(eventBus, view, proxy);
        this.service = provider.get();
        getView().setUiHandlers(this);
        this.placeManager = placeManager;

    }

    @Override
    protected void revealInParent() {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(ModuleNameTokens.SIDEMENU).build());
    }

    @Override
    public void onAccountList() {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(ModuleNameTokens.LIST).build());
    }

    @Override
    public void onAccountConfigure() {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(ModuleNameTokens.CONFIGURE).build());
    }

}

