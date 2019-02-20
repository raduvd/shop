package ro.msg.learning.repository.dao;

import org.springframework.stereotype.Component;
import ro.msg.learning.entity.Product;

/**
 * Created by vancer at 2/19/2019
 */
@Component
public interface ProductDao {

    public int insertProduct(Product product);
    public Product getProductById(Long id);
    public int deleteProduct(Long id);
}
