package net.canang.cca.web.client.widget;

import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.*;
import com.sencha.gxt.widget.core.client.event.TriggerClickEvent;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import net.canang.cca.web.client.AccountModel;
import net.canang.cca.web.client.AccountServiceAsync;
import net.canang.cca.web.client.loader.AccountRpcProxy;

/**
 * @author rafizan.baharum
 * @since 6/3/13
 */
public class AccountComboBox extends ComboBox<AccountModel> {

    public AccountComboBox(AccountServiceAsync service) {
        super(new AccountComboBoxCell(new ListStore<AccountModel>(new AccountModel.MyKeyProvider()), new AccountModel.MyLabelProvider()));
        setForceSelection(true);
        setMinChars(3);
        setTriggerAction(ComboBoxCell.TriggerAction.ALL);
        setEmptyText("Sila pilih account");
        AccountRpcProxy proxy = new AccountRpcProxy(service);
        final ListLoader<ListLoadConfig, ListLoadResult<AccountModel>> loader = new ListLoader<ListLoadConfig, ListLoadResult<AccountModel>>(proxy);
        loader.useLoadConfig(new ListLoadConfigBean());
        loader.addLoadHandler(new LoadResultListStoreBinding<ListLoadConfig, AccountModel, ListLoadResult<AccountModel>>(getCell().getStore()));
        addTriggerClickHandler(new TriggerClickEvent.TriggerClickHandler() {
            @Override
            public void onTriggerClick(TriggerClickEvent event) {
                loader.load();
            }
        });
        setLoader(loader);
    }
}
