package net.canang.cca.web.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import net.canang.cca.web.client.AccountServiceAsync;
import net.canang.cca.web.client.presenter.RootPresenter;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class RootView extends ViewImpl implements RootPresenter.MyView {

    @UiField(provided = true)
    MarginData outerData = new MarginData(5);
    @UiField(provided = true)
    BorderLayoutContainer.BorderLayoutData northData = new BorderLayoutContainer.BorderLayoutData(33);
    @UiField(provided = true)
    BorderLayoutContainer.BorderLayoutData westData = new BorderLayoutContainer.BorderLayoutData(200);
    @UiField(provided = true)
    MarginData centerData = new MarginData();
    @UiField
    ContentPanel mainContentPanel;
    @UiField
    ContentPanel sideContentPanel;
    @UiField
    ContentPanel topContentPanel;
    @UiField
    BorderLayoutContainer con;

    private final Widget widget;

    interface RootViewUiBinder extends UiBinder<Component, RootView> {
    }

    private static RootViewUiBinder ourUiBinder = GWT.create(RootViewUiBinder.class);

    @Inject
    public RootView(Provider<AccountServiceAsync> provider, PlaceManager placeManager) {
        widget = ourUiBinder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {

        northData.setMargins(new Margins(0, 5, 5, 5));
        westData.setMargins(new Margins(0, 5, 0, 5));
        centerData.setMargins(new Margins(0, 5, 0, 0));
        westData.setCollapsible(true);
        westData.setSplit(true);
        mainContentPanel.setHeight(500);
        sideContentPanel.setHeight(500);
//        sideContentPanel.setBodyBorder(false);
//        mainContentPanel.setBodyBorder(false);
//        topContentPanel.setBodyBorder(false);

        return widget;
    }


    // GWTP will call setInSlot when a child presenter asks to be added under
    // this view.
    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == RootPresenter.CONTENT) {
            setMainContent(content);
        } else if (slot == RootPresenter.SIDE) {
            setSideContent(content);
        } else if (slot == RootPresenter.TOP) {
            setTopContent(content);
        } else {
            super.setInSlot(slot, content);
        }
    }

    private void setMainContent(IsWidget content) {
        mainContentPanel.clear();
        if (content != null) {
            mainContentPanel.add(content);
        }
    }

    private void setSideContent(IsWidget content) {
        sideContentPanel.clear();
        if (content != null) {
            sideContentPanel.add(content);
        }
    }

    private void setTopContent(IsWidget content) {
        topContentPanel.clear();
        if (content != null) {
            topContentPanel.add(content);
        }
    }
}