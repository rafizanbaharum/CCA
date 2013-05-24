package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaUser;
import org.springframework.stereotype.Component;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
@Component("userDao")
public interface CaUserDao {

    CaUser findById(Long id);

    CaUser findByUsername(String username);

}
