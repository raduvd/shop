package ro.msg.learning.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import ro.msg.learning.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vancer at 2/20/2019
 */
public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {

        Product product = new Product();

        product.setId(resultSet.getLong("id"));
        product.setName(resultSet.getString("name"));
        product.setDescription(resultSet.getString("description"));
        product.setPrice(resultSet.getBigDecimal("id"));
        product.setWeight(resultSet.getDouble("weight"));
        product.setProductCategory(resultSet.getLong("product_category"));
        product.setSupplier(resultSet.getLong("supplier"));

        return product;
    }
}
//productCategory
//productCategory