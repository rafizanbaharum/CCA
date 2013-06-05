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
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import net.canang.cca.web.client.AccountServiceAsync;

import static net.canang.cca.web.client.presenter.ModuleNameTokens.HOME;
import static net.canang.cca.web.client.presenter.ModuleNameTokens.LIST;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class TopMenuPresenter extends Presenter<TopMenuPresenter.MyView, TopMenuPresenter.MyProxy> implements TopMenuUiHandlers {

    public interface MyView extends View, HasUiHandlers<TopMenuUiHandlers> {
    }

    @ProxyStandard
    @NameToken(ModuleNameTokens.TOPMENU)
    public interface MyProxy extends ProxyPlace<TopMenuPresenter> {
    }

    private AccountServiceAsync service;
    private PlaceManager placeManager;

    @Inject
    public TopMenuPresenter(Provider<AccountServiceAsync> provider, EventBus eventBus, MyView view, MyProxy proxy,
                            final PlaceManager placeManager) {
        super(eventBus, view, proxy);
        this.service = provider.get();
        this.placeManager = placeManager;
        getView().setUiHandlers(this);
    }

    @Override
    public void onHome() {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(HOME).build());
    }

    @Override
    public void onAccountList() {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(LIST).build());
    }

    @Override
    public void onAccountConfigure() {
    }

    @Override
    protected void revealInParent() {
        RevealRootContentEvent.fire(this, this);
    }
}
