package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaAccount;
import org.springframework.stereotype.Component;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
@Component("accountDao")
public interface CaAccountDao {

    CaAccount findById(Long id);

    CaAccount findByCode(String code);

}
