package net.canang.cca.web.client.loader;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import net.canang.cca.web.client.AccountModel;
import net.canang.cca.web.client.AccountServiceAsync;

/**
 * @author rafizan.baharum
 * @since 6/3/13
 */
public class AccountRpcProxy extends RpcProxy<ListLoadConfig, ListLoadResult<AccountModel>> {

    private AccountServiceAsync service;

    public AccountRpcProxy(AccountServiceAsync service) {
        this.service = service;
    }

    @Override
    public void load(ListLoadConfig loadConfig, final AsyncCallback<ListLoadResult<AccountModel>> async) {
        service.findAccounts(new AsyncCallback<ListLoadResult<AccountModel>>() {
            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(ListLoadResult<AccountModel> result) {
                async.onSuccess(result);
            }
        });
    }
}
