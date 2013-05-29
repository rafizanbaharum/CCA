package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaSite;
import net.canang.cca.core.model.CaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaSiteDao {

    CaSite findById(Long id);

    CaSite findByCode(String code);

    List<CaSite> find();

    void save(CaSite site, CaUser user);

    void update(CaSite site, CaUser user);

    void remove(CaSite site, CaUser user);
}
