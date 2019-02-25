package ro.msg.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.entity.ProductCategory;

/**
 * Created by vancer at 2/19/2019
 */

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
