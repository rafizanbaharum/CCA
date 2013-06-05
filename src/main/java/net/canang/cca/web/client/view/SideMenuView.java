package net.canang.cca.web.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;
import net.canang.cca.web.client.AccountServiceAsync;
import net.canang.cca.web.client.presenter.SideMenuPresenter;
import net.canang.cca.web.client.presenter.SideMenuUiHandlers;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class SideMenuView extends ViewWithUiHandlers<SideMenuUiHandlers> implements SideMenuPresenter.MyView {

    interface SideMenuViewUiBinder extends UiBinder<Component, SideMenuView> {
    }

    private static SideMenuViewUiBinder ourUiBinder = GWT.create(SideMenuViewUiBinder.class);

    private Component root;

    private AccountServiceAsync service;

    private PlaceManager placeManager;

    @UiField
    ContentPanel panel;

    @UiField
    AccordionLayoutContainer con;

    @UiField
    ContentPanel users;

    @UiFactory
    public ContentPanel createContentPanel(ContentPanel.ContentPanelAppearance appearance) {
        return new ContentPanel(appearance);
    }

    @Inject
    public SideMenuView(Provider<AccountServiceAsync> provider, PlaceManager placeManager) {
        root = ourUiBinder.createAndBindUi(this);
        this.service = provider.get();
        this.placeManager = placeManager;
        con.setActiveWidget((ContentPanel) con.getWidget(0));
    }

    @Override
    public Widget asWidget() {
        return root;
    }
}
