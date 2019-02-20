package ro.msg.learning.repository.daoImpl;

import org.springframework.stereotype.Component;
import ro.msg.learning.entity.Product;

/**
 * Created by vancer at 2/19/2019
 */
@Component
public interface ProductDao {

    public void insertProduct(Product product);
    public Product getProductById(Long id);
}
