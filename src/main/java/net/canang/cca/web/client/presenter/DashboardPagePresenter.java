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

import static net.canang.cca.web.client.presenter.ModuleNameTokens.CONFIGURE;
import static net.canang.cca.web.client.presenter.ModuleNameTokens.LIST;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class DashboardPagePresenter extends Presenter<DashboardPagePresenter.MyView, DashboardPagePresenter.MyProxy> implements DashboardUiHandlers {

    public interface MyView extends View, HasUiHandlers<DashboardUiHandlers> {
    }

    @ProxyStandard
    @NameToken(ModuleNameTokens.DASHBOARD)
    public interface MyProxy extends ProxyPlace<DashboardPagePresenter> {
    }

    private AccountServiceAsync service;
    private PlaceManager placeManager;

    @Inject
    public DashboardPagePresenter(Provider<AccountServiceAsync> provider, EventBus eventBus, MyView view, MyProxy proxy,
                                  final PlaceManager placeManager) {
        super(eventBus, view, proxy);
        this.service = provider.get();
        this.placeManager = placeManager;
        getView().setUiHandlers(this);
    }

    @Override
    public void onList() {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(LIST).with("id", "0").build());
    }

    @Override
    public void onConfigure() {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(CONFIGURE).build());
    }

    @Override
    protected void revealInParent() {
        RevealRootContentEvent.fire(this, this);
    }
}
