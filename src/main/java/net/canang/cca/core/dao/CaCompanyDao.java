package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaCompany;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaCompanyDao {

    CaCompany findById(Long id);

    CaCompany findByCode(String code);

    List<CaCompany> find();
}
