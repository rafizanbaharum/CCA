package net.canang.cca.web.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.widget.core.client.button.TextButton;
import net.canang.cca.web.client.AccountServiceAsync;
import net.canang.cca.web.client.presenter.AccountConfigurePresenter;
import net.canang.cca.web.client.presenter.AccountConfigureUiHandlers;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class AccountConfigureView extends ViewWithUiHandlers<AccountConfigureUiHandlers> implements AccountConfigurePresenter.MyView {

    interface AccountConfigureViewUiBinder extends UiBinder<HorizontalPanel, AccountConfigureView> {
    }

    private static AccountConfigureViewUiBinder ourUiBinder = GWT.create(AccountConfigureViewUiBinder.class);

    private HorizontalPanel rootElement;

    private AccountServiceAsync service;

    @UiField
    TextButton cancel;
    @UiField
    TextButton save;

    @Inject
    public AccountConfigureView(Provider<AccountServiceAsync> provider) {
        rootElement = ourUiBinder.createAndBindUi(this);
        this.service = provider.get();
    }

    @Override
    public Widget asWidget() {
        return rootElement;
    }
}
