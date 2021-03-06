package net.canang.cca.core.model;

import net.canang.cca.CaConfig;
import net.canang.cca.core.dao.CaUserDao;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author rafizan.baharum
 * @since 5/26/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CaConfig.class})
public class CaUserTest {

    private Logger log = LoggerFactory.getLogger(CaUserTest.class);

    @Autowired
    private CaUserDao userDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void retrieveAccount() {
        CaUser user = userDao.findByUsername("admin");
        log.info("user {}", user.getUsername());
    }
}

