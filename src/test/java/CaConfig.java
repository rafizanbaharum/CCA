import net.canang.cca.core.dao.CaUserDao;
import net.canang.cca.core.dao.impl.CaUserDaoImpl;
import net.canang.cca.core.model.impl.CaAccountImpl;
import net.canang.cca.core.model.impl.CaGroupImpl;
import net.canang.cca.core.model.impl.CaUserImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * @author rafizan.baharum
 * @since 5/26/13
 */
@Configuration
@EnableTransactionManagement
public class CaConfig {


    @Bean
    public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(dataSource())
                .addAnnotatedClasses(CaUserImpl.class)
                .addAnnotatedClasses(CaGroupImpl.class)
                .buildSessionFactory();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory());
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername("cca");
        basicDataSource.setPassword("abc123");
        basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521/ORCL");
        basicDataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        return basicDataSource;
    }

    @Bean
    public CaUserDao userDao() {
        return new CaUserDaoImpl();
    }
}