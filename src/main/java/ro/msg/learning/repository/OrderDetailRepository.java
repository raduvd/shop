package ro.msg.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.entity.OrderDetail;
import ro.msg.learning.entity.composite.OrderDetailCompositeKey;

/**
 * Created by vancer at 2/19/2019
 */

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailCompositeKey> {
}
