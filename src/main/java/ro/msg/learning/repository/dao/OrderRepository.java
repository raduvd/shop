package ro.msg.learning.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.entity.Order;

/**
 * Created by vancer at 2/19/2019
 */

public interface OrderRepository extends JpaRepository<Order, Long> {
}
