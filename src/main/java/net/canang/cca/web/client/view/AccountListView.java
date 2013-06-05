package net.canang.cca.web.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.ListLoader;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.event.RowDoubleClickEvent;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridView;
import net.canang.cca.web.client.AccountModel;
import net.canang.cca.web.client.AccountServiceAsync;
import net.canang.cca.web.client.loader.AccountRpcProxy;
import net.canang.cca.web.client.presenter.AccountListPresenter;
import net.canang.cca.web.client.presenter.AccountListUiHandlers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class AccountListView extends ViewWithUiHandlers<AccountListUiHandlers> implements AccountListPresenter.MyView {

    interface AccountListViewUiBinder extends UiBinder<Component, AccountListView> {
    }

    private static AccountListViewUiBinder ourUiBinderAccount = GWT.create(AccountListViewUiBinder.class);

    private Component root;

    private AccountServiceAsync service;

    private PlaceManager placeManager;

    @UiField
    ColumnModel<AccountModel> cm;
    @UiField
    ListStore<AccountModel> store;
    @UiField
    Grid grid;
    @UiField
    GridView<AccountModel> view;

    @Inject
    public AccountListView(Provider<AccountServiceAsync> provider, PlaceManager placeManager) {
        root = ourUiBinderAccount.createAndBindUi(this);
        this.service = provider.get();
        this.placeManager = placeManager;

        AccountModel.AccountProperties p = GWT.create(AccountModel.AccountProperties.class);
        AccountRpcProxy proxy = new AccountRpcProxy(service);
        final ListLoader<ListLoadConfig, ListLoadResult<AccountModel>> loader = new ListLoader<ListLoadConfig, ListLoadResult<AccountModel>>(proxy);
        loader.addLoadHandler(new LoadResultListStoreBinding<ListLoadConfig, AccountModel, ListLoadResult<AccountModel>>(store));
        grid.setLoader(loader);

        grid.addRowDoubleClickHandler(new RowDoubleClickEvent.RowDoubleClickHandler() {
            @Override
            public void onRowDoubleClick(RowDoubleClickEvent event) {
                getUiHandlers().onView(store.get(event.getRowIndex()).getId());
            }
        });

        Timer t = new Timer() {
            @Override
            public void run() {
                loader.load();
            }
        };
        t.schedule(100);
    }

    @UiFactory
    ColumnModel<AccountModel> createColumnModel() {
        AccountModel.AccountProperties p = GWT.create(AccountModel.AccountProperties.class);
        ColumnConfig<AccountModel, String> code = new ColumnConfig<AccountModel, String>(p.code(), 150, "Code");
        ColumnConfig<AccountModel, String> description = new ColumnConfig<AccountModel, String>(p.description(), 150, "Description");
        ColumnConfig<AccountModel, String> alias = new ColumnConfig<AccountModel, String>(p.alias(), 150, "Alias");
        List<ColumnConfig<AccountModel, ?>> l = new ArrayList<ColumnConfig<AccountModel, ?>>();
        l.add(code);
        l.add(description);
        l.add(alias);
        cm = new ColumnModel<AccountModel>(new ArrayList<ColumnConfig<AccountModel, ?>>(l));
        return cm;
    }

    @UiFactory
    ListStore<AccountModel> createListStore() {
        store = new ListStore<AccountModel>(new AccountModel.MyKeyProvider());
        return store;
    }

    @Override
    public Widget asWidget() {
        return root;
    }
}
