package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaLocationCode;
import net.canang.cca.core.model.CaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaLocationCodeDao {

    CaLocationCode findById(Long id);

    CaLocationCode findByCode(String code);

    List<CaLocationCode> find();

    void save(CaLocationCode accountCode, CaUser user);

    void update(CaLocationCode accountCode, CaUser user);

    void remove(CaLocationCode accountCode, CaUser user);
}
