package net.canang.cca.web.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.box.MessageBox;

/**
 * @author rafizan.baharum
 * @since 6/3/13
 */
public class Account implements EntryPoint {
    @Override
    public void onModuleLoad() {

        MessageBox messageBox = new MessageBox("First GXT 3 App", "Hello, World!");

        RootPanel.get().add(messageBox);

        messageBox.show();

    }
}
