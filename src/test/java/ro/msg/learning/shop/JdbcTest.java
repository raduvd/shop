package ro.msg.learning.shop;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ro.msg.learning.entity.Product;
import ro.msg.learning.entity.ProductCategory;
import ro.msg.learning.repository.dao.ProductCategoryDao;
import ro.msg.learning.repository.dao.ProductDao;

/**
 * Created by vancer at 3/8/2019
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ShopApplication.class)
public class JdbcTest {

    private final static String DESCRIPTION = "Test Description";
    private final static String NAME = "Test Name";
    private final static Long ID = 1L;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testCrudOperations() {

        Product product = new Product();
        product.setId(ID);
        product.setDescription(DESCRIPTION);
        product.setName(NAME);
        product.setSupplier(ID);
        product.setProductCategory(ID);

        final int insertedProducts = productDao.insertProduct(product);
        final Product productReturned = productDao.getProductById(ID);
        final int deletedProducts = productDao.deleteProduct(ID);

        final ProductCategory productCategory = new ProductCategory();
        productCategory.setId(ID);
        productCategory.setDescription(DESCRIPTION);
        productCategory.setName(NAME);

        final int insertedProductCategory = productCategoryDao.insertProductCategoryIfNotPresent(productCategory);
        final ProductCategory productCategoryReturned = productCategoryDao.getProductCategoryById(ID);

        Assert.assertTrue(insertedProducts == 1);
        Assert.assertTrue(productReturned.getName().equals(NAME));
        Assert.assertTrue(productReturned.getDescription().equals(DESCRIPTION));
        Assert.assertTrue(deletedProducts == 1);
        Assert.assertTrue(insertedProductCategory == 1);
        Assert.assertTrue(productCategoryReturned.getName().equals(NAME));
        Assert.assertTrue(productCategoryReturned.getDescription().equals(DESCRIPTION));
    }
}