package net.canang.cca.web.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import net.canang.cca.web.client.AccountServiceAsync;
import net.canang.cca.web.client.presenter.AccountHomePresenter;
import net.canang.cca.web.client.presenter.AccountHomeUiHandlers;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class AccountHomeView extends ViewWithUiHandlers<AccountHomeUiHandlers> implements AccountHomePresenter.MyView {

    interface AccountHomeViewUiBinder extends UiBinder<HorizontalPanel, AccountHomeView> {
    }


    private static AccountHomeViewUiBinder ourUiBinder = GWT.create(AccountHomeViewUiBinder.class);

    private HorizontalPanel rootElement;

    private AccountServiceAsync service;

    private PlaceManager placeManager;
    @UiField
    HTML display;

    @Inject
    public AccountHomeView(Provider<AccountServiceAsync> provider, PlaceManager placeManager) {
        rootElement = ourUiBinder.createAndBindUi(this);
        this.service = provider.get();
        this.placeManager = placeManager;
        display.setHTML("TEST HOME");

    }

    @Override
    public Widget asWidget() {
        return rootElement;
    }
}
