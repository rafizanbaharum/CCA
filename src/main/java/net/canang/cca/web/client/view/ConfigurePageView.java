package net.canang.cca.web.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridView;
import net.canang.cca.web.client.AccountModel;
import net.canang.cca.web.client.AccountServiceAsync;
import net.canang.cca.web.client.presenter.DashboardPagePresenter;
import net.canang.cca.web.client.presenter.DashboardUiHandlers;

import java.util.LinkedList;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class ConfigurePageView extends ViewWithUiHandlers<DashboardUiHandlers> implements DashboardPagePresenter.MyView {

    interface MainPageViewUiBinder extends UiBinder<HorizontalPanel, ConfigurePageView> {
    }

    private static MainPageViewUiBinder ourUiBinder = GWT.create(MainPageViewUiBinder.class);

    private HorizontalPanel rootElement;

    private AccountServiceAsync service;

    @UiField
    HTML display;
    @UiField
    DateField lastTrans;
    @UiField
    TextButton reset;
    @UiField
    TextButton save;
    @UiField
    TextField symbol;
    @UiField
    NumberField last;
    @UiField
    TextField name;
    @UiField
    NumberField change;

    @UiField(provided = true)
    NumberPropertyEditor<Double> doublePropertyEditor = new NumberPropertyEditor.DoublePropertyEditor();
    @UiField(provided = true)
    NumberFormat numberFormat = NumberFormat.getFormat("0.00");

    @UiField
    ColumnModel<AccountModel> cm;

    @UiField
    ListStore<AccountModel> store;

    @UiField
    Grid<AccountModel> grid;

    @UiField
    GridView<AccountModel> view;

    @UiFactory
    ColumnModel<AccountModel> createColumnModel() {
        AccountModel.AccountProperties props = GWT.create(AccountModel.AccountProperties.class);
        List<ColumnConfig<AccountModel, ?>> cc = new LinkedList<ColumnConfig<AccountModel, ?>>();
        cc.add(new ColumnConfig<AccountModel, String>(props.code(), 200, "Code"));
        cc.add(new ColumnConfig<AccountModel, String>(props.description(), 200, "Description"));
        cc.add(new ColumnConfig<AccountModel, String>(props.alias(), 200, "Alias"));
        cm = new ColumnModel<AccountModel>(cc);
        return cm;
    }

    @UiFactory
    ListStore<AccountModel> createListStore() {
        AccountModel.AccountProperties props = GWT.create(AccountModel.AccountProperties.class);
        store = new ListStore<AccountModel>(props.id());
        return store;
    }


    @Inject
    public ConfigurePageView(Provider<AccountServiceAsync> provider) {
        rootElement = ourUiBinder.createAndBindUi(this);
        this.service = provider.get();
    }

    @Override
    public Widget asWidget() {
        return rootElement;
    }
}
