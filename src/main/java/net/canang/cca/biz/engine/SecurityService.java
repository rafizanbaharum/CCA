package net.canang.cca.biz.engine;

import net.canang.cca.core.dao.CaUserDao;
import net.canang.cca.core.model.CaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class SecurityService {

    @Autowired
    private CaUserDao userDao;

    public CaUser getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        return userDao.findByUsername(userDetails.getUsername());
    }
}
