package net.canang.cca.web.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.data.shared.loader.*;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import net.canang.cca.web.client.loader.AccountRpcProxy;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 6/3/13
 */
public class AccountEntryPoint implements EntryPoint {
    @Override
    public void onModuleLoad() {

        final StringBuffer s = new StringBuffer();
        AccountModel.AccountProperties accountProperties = GWT.create(AccountModel.AccountProperties.class);
        AccountServiceAsync accountService = GWT.create(AccountService.class);
        ServiceDefTarget accountEndpoint = (ServiceDefTarget) accountService;
        accountEndpoint.setServiceEntryPoint(com.google.gwt.core.client.GWT.getModuleBaseURL() + "AccountService");

        AccountRpcProxy proxy = new AccountRpcProxy(accountService);
        ListLoader<ListLoadConfig, ListLoadResult<AccountModel>> loader = new ListLoader<ListLoadConfig, ListLoadResult<AccountModel>>(proxy);
        loader.load(new ListLoadConfigBean());
        System.out.print("loading");
        LoaderHandler<ListLoadConfig, ListLoadResult<AccountModel>> accountLoaderHandler = new LoaderHandler<ListLoadConfig, ListLoadResult<AccountModel>>() {
            @Override
            public void onBeforeLoad(BeforeLoadEvent<ListLoadConfig> listLoadConfigBeforeLoadEvent) {
            }

            @Override
            public void onLoadException(LoadExceptionEvent<ListLoadConfig> listLoadConfigLoadExceptionEvent) {
                // TODO:
            }

            @Override
            public void onLoad(LoadEvent<ListLoadConfig, ListLoadResult<AccountModel>> result) {
                // TODO:
                List<AccountModel> accounts = result.getLoadResult().getData();
                for (AccountModel account : accounts) {
                    s.append(account.getCode());
                }

                MessageBox messageBox = new MessageBox("Message", s.toString());
                RootPanel.get().add(messageBox);
                messageBox.show();
            }
        };
        loader.addLoaderHandler(accountLoaderHandler);

    }
}
