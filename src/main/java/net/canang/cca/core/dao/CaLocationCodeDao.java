package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaDepartmentCode;
import net.canang.cca.core.model.CaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaLocationCodeDao {

    CaDepartmentCode findById(Long id);

    CaDepartmentCode findByCode(String code);

    List<CaDepartmentCode> find();

    void save(CaDepartmentCode accountCode, CaUser user);

    void update(CaDepartmentCode accountCode, CaUser user);

    void remove(CaDepartmentCode accountCode, CaUser user);
}
