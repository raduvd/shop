package ro.msg.learning.repository.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ro.msg.learning.entity.ProductCategory;

/**
 * Created by vancer at 2/19/2019
 */
@Component
public interface ProductCategoryDao {

    int insertProductCategoryIfNotPresent(ProductCategory product);

    ProductCategory getProductCategoryById(Long id);

    int deleteProductCategory(Long id);

    NamedParameterJdbcTemplate getJdbcTemplate();
}
