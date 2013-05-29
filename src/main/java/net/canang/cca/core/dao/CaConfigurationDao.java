package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaConfiguration;
import net.canang.cca.core.model.CaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaConfigurationDao {

    CaConfiguration findById(Long id);

    CaConfiguration findByKey(String key);

    List<CaConfiguration> find();

    void save(CaConfiguration configuration, CaUser user);

    void update(CaConfiguration configuration, CaUser user);

    void remove(CaConfiguration configuration, CaUser user);
}
