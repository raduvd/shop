package ro.msg.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.entity.Supplier;

/**
 * Created by vancer at 2/19/2019
 */

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
