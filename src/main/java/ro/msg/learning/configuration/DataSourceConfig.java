package ro.msg.learning.configuration;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by vancer at 2/18/2019
 */

@Configuration
public class DataSourceConfig {

    private static final String DB_PATH = System.getProperty("java.io.tmpdir");

    @Bean(name = "jdbcDataSource")
    public DataSource createMainDataSource() {
        JdbcDataSource ds = new JdbcDataSource();
        //ds.setURL("jdbc:h2:"+TEMP_DIRECTORY+"/testdata;MODE=MySQL");
        ds.setURL("jdbc:h2:C:\\Users\\vancer\\IdeaProjects\\shop - Copy\\Database\\shop_db");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource jdbcDataSource) {
        return new JdbcTemplate(jdbcDataSource);}

}
