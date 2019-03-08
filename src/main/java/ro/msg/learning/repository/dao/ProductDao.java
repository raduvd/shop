package ro.msg.learning.repository.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ro.msg.learning.entity.Product;

/**
 * Created by vancer at 2/19/2019
 */
@Component
public interface ProductDao {

    int insertProduct(Product product);

    Product getProductById(Long id);

    int deleteProduct(Long id);

    JdbcTemplate getJdbcTemplate();
}
