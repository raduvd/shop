package ro.msg.learning.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import ro.msg.learning.entity.Product;
import ro.msg.learning.entity.ProductCategory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vancer at 2/20/2019
 */
public class ProductCategoryRowMapper implements RowMapper<ProductCategory> {

    @Override
    public ProductCategory mapRow(ResultSet resultSet, int i) throws SQLException {

        ProductCategory product = new ProductCategory();

        product.setId(resultSet.getLong("id"));
        product.setName(resultSet.getString("name"));
        product.setDescription(resultSet.getString("description"));

        return product;
    }
}
