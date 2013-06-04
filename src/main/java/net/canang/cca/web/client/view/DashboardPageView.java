package net.canang.cca.web.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.sencha.gxt.widget.core.client.ContentPanel;
import net.canang.cca.web.client.AccountServiceAsync;
import net.canang.cca.web.client.presenter.DashboardPagePresenter;
import net.canang.cca.web.client.presenter.DashboardUiHandlers;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class DashboardPageView extends ViewWithUiHandlers<DashboardUiHandlers> implements DashboardPagePresenter.MyView {

    interface DashboardPageViewUiBinder extends UiBinder<HorizontalPanel, DashboardPageView> {
    }

    private static DashboardPageViewUiBinder ourUiBinder = GWT.create(DashboardPageViewUiBinder.class);

    private HorizontalPanel rootElement;

    private AccountServiceAsync service;
    private PlaceManager placeManager;

    @UiField
    Anchor listAnchor;

    @UiField
    Anchor configureAnchor;
    @UiField
    ContentPanel leftRegion;
    @UiField
    ContentPanel rightRegion;

    @Inject
    public DashboardPageView(Provider<AccountServiceAsync> provider, PlaceManager placeManager) {
        rootElement = ourUiBinder.createAndBindUi(this);
        this.service = provider.get();
        this.placeManager = placeManager;

        listAnchor.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                onList(event);
            }
        });

        configureAnchor.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                onList(event);
            }
        });
    }

    @Override
    public Widget asWidget() {
        return rootElement;
    }

    @UiHandler("listAnchor")
    public void onList(ClickEvent event) {
        getUiHandlers().onList();
    }

    @UiHandler("configureAnchor")
    public void onConfigure(ClickEvent event) {
        getUiHandlers().onConfigure();
    }
}
