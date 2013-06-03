package net.canang.cca.web.server;

import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.ListLoadResultBean;
import net.canang.cca.core.dao.CaAccountDao;
import net.canang.cca.core.model.CaAccount;
import net.canang.cca.web.client.AccountModel;
import net.canang.cca.web.client.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 6/3/13
 */
public class AccountServiceImpl extends SpringSupportRemoteServlet implements AccountService {

    private static final long serialVersionUID = 1L;

    @Autowired
    private CaAccountDao accountDao;

    public ListLoadResult<AccountModel> findAccounts() {
        List<CaAccount> accounts = accountDao.find();
        List<AccountModel> acc = new ArrayList<AccountModel>();
        for (CaAccount account : accounts) {
            AccountModel m = new AccountModel();
            m.setCode(account.getCode());
            m.setDescription(account.getDescription());
            m.setAlias(account.getAlias());
            acc.add(m);
        }
        return new ListLoadResultBean<AccountModel>(acc);
    }
}
