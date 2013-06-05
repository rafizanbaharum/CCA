package net.canang.cca.web.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.menu.Item;
import com.sencha.gxt.widget.core.client.menu.MenuItem;
import net.canang.cca.web.client.AccountServiceAsync;
import net.canang.cca.web.client.presenter.TopMenuPresenter;
import net.canang.cca.web.client.presenter.TopMenuUiHandlers;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class TopMenuView extends ViewWithUiHandlers<TopMenuUiHandlers> implements TopMenuPresenter.MyView {

    interface TopMenuViewUiBinder extends UiBinder<Component, TopMenuView> {
    }

    private static TopMenuViewUiBinder ourUiBinder = GWT.create(TopMenuViewUiBinder.class);

    private AccountServiceAsync service;
    private PlaceManager placeManager;

    private Component root;

    @UiField
    MenuItem accountItem;
    @UiField
    MenuItem configureItem;
    @UiField
    MenuItem homeItem;

    @Inject
    public TopMenuView(Provider<AccountServiceAsync> provider, PlaceManager placeManager) {
        root = ourUiBinder.createAndBindUi(this);
        this.service = provider.get();
        this.placeManager = placeManager;
    }

    @Override
    public Widget asWidget() {
        return root;
    }

    @UiHandler("homeItem")
    public void onHomeSelection(SelectionEvent<Item> itemEvent) {
        getUiHandlers().onHome();
    }
    @UiHandler("accountItem")
    public void onAccountSelection(SelectionEvent<Item> itemEvent) {
        getUiHandlers().onAccountList();
    }
}
