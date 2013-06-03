package net.canang.cca.web.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.data.shared.loader.ListLoadResult;

/**
 * @author rafizan.baharum
 * @since 6/3/13
 */
public interface AccountServiceAsync {

    void findAccounts(AsyncCallback<ListLoadResult<AccountModel>> async);
}
