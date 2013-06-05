package net.canang.cca.web.client.presenter;

import com.google.gwt.event.shared.GwtEvent;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class RootPresenter extends Presenter<RootPresenter.MyView, RootPresenter.MyProxy> {

    public interface MyView extends View {
    }

    @ProxyStandard
    @NameToken(ModuleNameTokens.ROOT)
    public interface MyProxy extends ProxyPlace<RootPresenter> {
    }

    /**
     * Child presenters can fire a RevealContentEvent with TYPE_SetMainContent
     * to set themselves as children of this presenter.
     */
    @ContentSlot
    public static final GwtEvent.Type<RevealContentHandler<?>> TOP = new GwtEvent.Type<RevealContentHandler<?>>();

    @ContentSlot
    public static final GwtEvent.Type<RevealContentHandler<?>> CONTENT = new GwtEvent.Type<RevealContentHandler<?>>();

    @ContentSlot
    public static final GwtEvent.Type<RevealContentHandler<?>> SIDE = new GwtEvent.Type<RevealContentHandler<?>>();

    @Inject
    private SideMenuPresenter sideMenuPresenter;

    @Inject
    private TopMenuPresenter topMenuPresenter;

    @Inject
    private AccountHomePresenter homePresenter;

    private PlaceManager placeManager;


    @Inject
    public RootPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {
        super(eventBus, view, proxy);
        this.placeManager = placeManager;
    }


    @Override
    protected void onReveal() {
        super.onReveal();
        setInSlot(CONTENT, homePresenter);
        setInSlot(TOP, topMenuPresenter);
        setInSlot(SIDE, sideMenuPresenter);
    }

    @Override
    protected void revealInParent() {
        RevealRootContentEvent.fire(this, this);
    }
}