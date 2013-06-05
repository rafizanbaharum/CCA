package net.canang.cca.web.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.TextField;
import net.canang.cca.web.client.AccountModel;
import net.canang.cca.web.client.AccountServiceAsync;
import net.canang.cca.web.client.presenter.AccountViewPresenter;
import net.canang.cca.web.client.presenter.AccountViewUiHandlers;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class AccountViewView extends ViewWithUiHandlers<AccountViewUiHandlers> implements AccountViewPresenter.MyView, Editor<AccountModel> {

    interface AccountDriver extends SimpleBeanEditorDriver<AccountModel, AccountViewView> {
    }

    interface AccountViewViewUiBinder extends UiBinder<Component, AccountViewView> {
    }

    private static AccountViewViewUiBinder ourUiBinderAccount = GWT.create(AccountViewViewUiBinder.class);

    private AccountDriver driver = GWT.create(AccountDriver.class);

    private Component root;

    private AccountServiceAsync service;

    private PlaceManager placeManager;
    @UiField
    TextField code;
    @UiField
    TextArea description;
    @UiField
    TextField alias;

    @Inject
    public AccountViewView(Provider<AccountServiceAsync> provider, PlaceManager placeManager) {
        root = ourUiBinderAccount.createAndBindUi(this);
        this.service = provider.get();
        this.placeManager = placeManager;

        String id = placeManager.getCurrentPlaceRequest().getParameter("id", "0");
        this.service.findAccountById(Long.valueOf(id), new AsyncCallback<AccountModel>() {
            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(AccountModel result) {
                driver.edit(result);
            }
        });
        driver.initialize(this);
    }

    @Override
    public Widget asWidget() {
        return root;
    }
}
