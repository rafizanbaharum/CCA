package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaAccountCode;
import net.canang.cca.core.model.CaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaAccountCodeDao {

    CaAccountCode findById(Long id);

    CaAccountCode findByCode(String code);

    List<CaAccountCode> find();

    void save(CaAccountCode accountCode, CaUser user);

    void update(CaAccountCode accountCode, CaUser user);

    void remove(CaAccountCode accountCode, CaUser user);
}
