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

import static net.canang.cca.web.client.presenter.ModuleNameTokens.DASHBOARD;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class ListPagePresenter extends Presenter<ListPagePresenter.MyView, ListPagePresenter.MyProxy> implements ListUiHandlers {

    private PlaceManager placeManager;
    private AccountServiceAsync service;

    @Override
    public void onView() {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(DASHBOARD).build());
    }

    @Override
    public void onCancel() {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(DASHBOARD).build());
    }

    public interface MyView extends View, HasUiHandlers<ListUiHandlers> {
    }

    @ProxyStandard
    @NameToken(ModuleNameTokens.LIST)
    public interface MyProxy extends ProxyPlace<ListPagePresenter> {
    }

    @Inject
    public ListPagePresenter(Provider<AccountServiceAsync> provider, EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {
        super(eventBus, view, proxy);
        this.service = provider.get();
        getView().setUiHandlers(this);
        this.placeManager = placeManager;
    }

    @Override
    protected void revealInParent() {
        RevealRootContentEvent.fire(this, this);
    }
}
