package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaUnitCode;
import net.canang.cca.core.model.CaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaUnitCodeDao {

    CaUnitCode findById(Long id);

    CaUnitCode findByCode(String code);

    List<CaUnitCode> find();

    void save(CaUnitCode site, CaUser user);

    void update(CaUnitCode site, CaUser user);

    void remove(CaUnitCode site, CaUser user);
}
