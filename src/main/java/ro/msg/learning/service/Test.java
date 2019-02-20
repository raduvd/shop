package ro.msg.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.msg.learning.entity.Product;
import ro.msg.learning.entity.ProductCategory;
import ro.msg.learning.repository.dao.ProductCategoryDao;
import ro.msg.learning.repository.dao.ProductDao;

import java.math.BigDecimal;

/**
 * Created by vancer at 2/19/2019
 */
@Component
public class Test {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductCategoryDao productCategoryDao;

    public String test(Long id) {

        final Product product = new Product();

        product.setId(id);
        product.setDescription("Description");
        product.setName("Name");
        product.setPrice(new BigDecimal(2432));
        product.setWeight(23.4D);
        product.setSupplier(1L);
        product.setProductCategory(1L);

        final int insertedProducts = productDao.insertProduct(product);
        final Product productReturned = productDao.getProductById(id);
        final int deletedProducts = productDao.deleteProduct(id);

        final ProductCategory productCategory = new ProductCategory();
        productCategory.setId(1L);
        productCategory.setDescription("Description");
        productCategory.setName("Name");

        final int insertedProductCategory = productCategoryDao.insertProductCategoryIfNotPresent(productCategory);
        final ProductCategory productCategoryReturned = productCategoryDao.getProductCategoryById(1L);
        final int productCategoryDeleted = productCategoryDao.deleteProductCategory(1L);

        return "Inserted Products: " + insertedProducts + "\nProduct returned: " + productReturned + "\nDeleted Products: " + deletedProducts +
                "\nInserted ProductCategory: " + insertedProductCategory + "\nPoductCategory Returned: " + productCategoryReturned + "\nProductCategory Deleted: " + productCategoryDeleted;
    }
}
