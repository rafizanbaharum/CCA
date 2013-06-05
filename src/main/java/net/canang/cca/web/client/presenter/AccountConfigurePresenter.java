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
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import net.canang.cca.web.client.AccountServiceAsync;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class AccountConfigurePresenter extends Presenter<AccountConfigurePresenter.MyView, AccountConfigurePresenter.MyProxy> implements AccountConfigureUiHandlers {

    private PlaceManager placeManager;
    private AccountServiceAsync service;

    public interface MyView extends View, HasUiHandlers<AccountConfigureUiHandlers> {
    }

    @ProxyStandard
    @NameToken(ModuleNameTokens.CONFIGURE)
    public interface MyProxy extends ProxyPlace<AccountConfigurePresenter> {
    }

    @Inject
    public AccountConfigurePresenter(Provider<AccountServiceAsync> provider, EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {
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
        RevealRootContentEvent.fire(this, this);
    }
}
