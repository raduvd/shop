package ro.msg.learning.configuration;

import org.springframework.context.annotation.Configuration;

/**
 * Created by vancer at 2/18/2019
 */

@Configuration
public class DataSourceConfig {

   /* private static final String DB_PATH = System.getProperty("DB_PATH");

    @Bean(name = "jdbcDataSource")
    public DataSource createMainDataSource() {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:" + DB_PATH);
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource jdbcDataSource) {
        return new JdbcTemplate(jdbcDataSource);
    }*/

}
