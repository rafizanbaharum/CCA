package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaAccount;
import net.canang.cca.core.model.CaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaAccountDao {

    CaAccount findById(Long id);

    CaAccount findByCode(String code);

    List<CaAccount> find();

    void save(CaAccount account, CaUser creator);

    void update(CaAccount account, CaUser creator);

    void remove(CaAccount account, CaUser creator);

}
