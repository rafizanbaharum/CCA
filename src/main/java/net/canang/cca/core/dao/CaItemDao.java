package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaItem;
import net.canang.cca.core.model.CaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaItemDao {

    CaItem findById(Long id);

    CaItem findByCode(String code);

    List<CaItem> find();

    void save(CaItem site, CaUser user);

    void update(CaItem site, CaUser user);

    void remove(CaItem site, CaUser user);
}
