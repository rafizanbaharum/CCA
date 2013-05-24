package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaCompany;
import org.springframework.stereotype.Component;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
@Component("companyDao")
public interface CaCompanyDao {

    CaCompany findById(Long id);

    CaCompany findByCode(String code);

}
