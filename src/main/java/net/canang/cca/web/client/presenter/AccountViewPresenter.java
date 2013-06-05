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
public class AccountViewPresenter extends Presenter<AccountViewPresenter.MyView, AccountViewPresenter.MyProxy> implements AccountViewUiHandlers {

    private PlaceManager placeManager;
    private AccountServiceAsync service;

    public interface MyView extends View, HasUiHandlers<AccountViewUiHandlers> {
    }

    @ProxyStandard
    @NameToken(ModuleNameTokens.VIEW)
    public interface MyProxy extends ProxyPlace<AccountViewPresenter> {
    }

    @Inject
    public AccountViewPresenter(Provider<AccountServiceAsync> provider, EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {
        super(eventBus, view, proxy);
        this.service = provider.get();
        getView().setUiHandlers(this);
        this.placeManager = placeManager;
    }

    @Override
    public void onCreate() {
        // TODO:

    }

    @Override
    public void onUpdate() {
        // TODO:

    }

    @Override
    public void onCancel() {
        // TODO:

    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, RootPresenter.CONTENT, this);
    }
}
