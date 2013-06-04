package net.canang.cca.web.client.widget;

import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import net.canang.cca.web.client.AccountModel;

/**
 * @author rafizan.baharum
 * @since 6/3/13
 */
public class AccountComboBoxCell extends ComboBoxCell<AccountModel> {

    public AccountComboBoxCell(ListStore<AccountModel> store, LabelProvider<AccountModel> labelProvider) {
        super(store, labelProvider);
    }
}
