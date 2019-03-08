package ro.msg.learning.repository.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ro.msg.learning.entity.ProductCategory;
import ro.msg.learning.repository.dao.ProductCategoryDao;
import ro.msg.learning.repository.rowmapper.ProductCategoryRowMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vancer at 2/19/2019
 */
@Repository
@Component
public class ProductCategoryDaoImpl implements ProductCategoryDao {

    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    public ProductCategoryDaoImpl(NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    public int insertProductCategoryIfNotPresent(ProductCategory productCategory) {

        String sql = "INSERT INTO PRODUCT_CATEGORY(ID, NAME, DESCRIPTION) VALUES (:id,:name,:description) ";

        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("id", productCategory.getId());
        parameterMap.put("name", productCategory.getName());
        parameterMap.put("description", productCategory.getDescription());

        return namedJdbcTemplate.update(sql, parameterMap);
    }

    public ProductCategory getProductCategoryById(Long id) {
        String sql = "SELECT * from PRODUCT_CATEGORY where id=:id";

        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("id", id);

        return namedJdbcTemplate.queryForObject(sql, parameterMap, new ProductCategoryRowMapper());

    }

    public int deleteProductCategory(Long id) {

        String sql = "DELETE PRODUCT WHERE ID = :id";

        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("id", id);

        return namedJdbcTemplate.update(sql, parameterMap);
    }

    public NamedParameterJdbcTemplate getJdbcTemplate() {
        return namedJdbcTemplate;
    }
}


