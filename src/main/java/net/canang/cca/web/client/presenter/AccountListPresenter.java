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
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import net.canang.cca.web.client.AccountServiceAsync;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class AccountListPresenter extends Presenter<AccountListPresenter.MyView, AccountListPresenter.MyProxy> implements AccountListUiHandlers {

    private PlaceManager placeManager;
    private AccountServiceAsync service;

    public interface MyView extends View, HasUiHandlers<AccountListUiHandlers> {
    }

    @ProxyStandard
    @NameToken(ModuleNameTokens.LIST)
    public interface MyProxy extends ProxyPlace<AccountListPresenter> {
    }

    @Inject
    public AccountListPresenter(Provider<AccountServiceAsync> provider, EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {
        super(eventBus, view, proxy);
        this.service = provider.get();
        getView().setUiHandlers(this);
        this.placeManager = placeManager;
    }

    @Override
    public void onView() {
    }

    @Override
    public void onCancel() {
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, RootPresenter.CONTENT, this);
    }
}
