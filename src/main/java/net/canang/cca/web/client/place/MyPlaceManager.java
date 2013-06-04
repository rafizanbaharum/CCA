package net.canang.cca.web.client.place;


import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;
import net.canang.cca.web.client.presenter.ModuleNameTokens;

/**
 * @author rafizan.baharum
 * @since 6/4/13
 */
public class MyPlaceManager extends PlaceManagerImpl {

    @Inject
    public MyPlaceManager(
            EventBus eventBus,
            TokenFormatter tokenFormatter) {
        super(eventBus, tokenFormatter);
    }

    @Override
    public void revealDefaultPlace() {
        revealPlace(new PlaceRequest(ModuleNameTokens.DASHBOARD), false);
    }
}
