package net.canang.cca.web.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import net.canang.cca.web.client.AccountServiceAsync;
import net.canang.cca.web.client.presenter.ListPagePresenter;
import net.canang.cca.web.client.presenter.ListUiHandlers;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class ListPageView extends ViewWithUiHandlers<ListUiHandlers> implements ListPagePresenter.MyView {

    interface ListPageViewUiBinder extends UiBinder<HorizontalPanel, ListPageView> {
    }

    private static ListPageViewUiBinder ourUiBinder = GWT.create(ListPageViewUiBinder.class);

    private HorizontalPanel rootElement;

    private AccountServiceAsync service;

    private PlaceManager placeManager;
    @UiField
    TextButton cancel;
    @UiField
    TextButton save;

    @Inject
    public ListPageView(Provider<AccountServiceAsync> provider, PlaceManager placeManager) {
        rootElement = ourUiBinder.createAndBindUi(this);
        this.service = provider.get();
        this.placeManager = placeManager;

        System.out.println(placeManager.getCurrentPlaceRequest().getParameter("id", "0"));
    }

    @Override
    public Widget asWidget() {
        return rootElement;
    }

    @UiHandler("cancel")
    public void onCancel(SelectEvent event) {
        if (null != getUiHandlers())
            getUiHandlers().onCancel();
    }

    @UiHandler("save")
    public void onSave(SelectEvent event) {
        if (null != getUiHandlers())
            getUiHandlers().onCancel();
    }
}
