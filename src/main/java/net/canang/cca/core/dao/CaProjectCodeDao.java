package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaProjectCode;
import net.canang.cca.core.model.CaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaProjectCodeDao {

    CaProjectCode findById(Long id);

    CaProjectCode findByCode(String code);

    List<CaProjectCode> find();

    void save(CaProjectCode accountCode, CaUser user);

    void update(CaProjectCode accountCode, CaUser user);

    void remove(CaProjectCode accountCode, CaUser user);
}
