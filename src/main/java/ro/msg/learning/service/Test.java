package ro.msg.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.msg.learning.entity.Product;
import ro.msg.learning.repository.daoImpl.ProductDao;

import java.math.BigDecimal;

/**
 * Created by vancer at 2/19/2019
 */
@Component
public class Test {

    @Autowired
    private ProductDao productDao;

    public Product test(Long id) {

        final Product product = new Product();

        product.setId(id);
        product.setDescription("Description");
        product.setName("Name");
        product.setPrice(new BigDecimal(2432));
        product.setWeight(23.4D);
        product.setSupplier(1L);
        product.setProductCategory(1L);

        productDao.insertProduct(product);

        return productDao.getProductById(id);
    }
}
