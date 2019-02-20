package ro.msg.learning.repository.dao;

import org.springframework.stereotype.Component;
import ro.msg.learning.entity.Product;
import ro.msg.learning.entity.ProductCategory;

/**
 * Created by vancer at 2/19/2019
 */
@Component
public interface ProductCategoryDao {

    public int insertProductCategoryIfNotPresent(ProductCategory product);

    public ProductCategory getProductCategoryById(Long id);

    public int deleteProductCategory(Long id);
}
