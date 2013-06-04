package net.canang.cca.web.client.presenter;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import net.canang.cca.web.client.AccountServiceAsync;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class MainPagePresenter extends Presenter<MainPagePresenter.MyView, MainPagePresenter.MyProxy> {

    private AccountServiceAsync service;

    public interface MyView extends View {
    }

    @ProxyStandard
    @NameToken("main")
    public interface MyProxy extends ProxyPlace<MainPagePresenter> {
    }

    @Inject
    public MainPagePresenter(Provider<AccountServiceAsync> provider, EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy);
        this.service = provider.get();
    }

    @Override
    protected void revealInParent() {
        RevealRootContentEvent.fire(this, this);
    }
}
