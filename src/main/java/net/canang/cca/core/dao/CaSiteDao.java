package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaSiteCode;
import net.canang.cca.core.model.CaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaSiteDao {

    CaSiteCode findById(Long id);

    CaSiteCode findByCode(String code);

    List<CaSiteCode> find();

    void save(CaSiteCode siteCode, CaUser user);

    void update(CaSiteCode siteCode, CaUser user);

    void remove(CaSiteCode siteCode, CaUser user);
}
