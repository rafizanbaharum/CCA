package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaUser;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaUserDao {

    CaUser findById(Long id);

    CaUser findByUsername(String username);

    void save(CaUser user, CaUser creator);

    void update(CaUser user, CaUser creator);

    void remove(CaUser user, CaUser creator);

}
