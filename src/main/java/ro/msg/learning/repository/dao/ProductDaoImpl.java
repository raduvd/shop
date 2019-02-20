package ro.msg.learning.repository.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ro.msg.learning.entity.Product;
import ro.msg.learning.repository.daoImpl.ProductDao;
import ro.msg.learning.repository.rowmapper.ProductRowMapper;

/**
 * Created by vancer at 2/19/2019
 */
@Repository
@Component
public class ProductDaoImpl implements ProductDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertProduct(Product product) {

        String sql = "INSERT INTO PRODUCT " +
                "(ID, NAME, DESCRIPTION, PRICE, WEIGHT,PRODUCT_CATEGORY,SUPPLIER) VALUES (?, ?, ?,?,?,?,?)";

        jdbcTemplate.update(sql, product.getId(), product.getName(),
                product.getDescription(), product.getPrice(), product.getWeight(), product.getProductCategory(), product.getSupplier());
    }

    public Product getProductById(Long id) {

        String sql ="SELECT * from PRODUCT where id = ?";

        return jdbcTemplate.queryForObject(sql, new ProductRowMapper(),id);
    }

}


