package ro.msg.learning.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.entity.Order;

import java.util.Date;
import java.util.List;

/**
 * Created by vancer at 2/19/2019
 */

public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Order> getByDateOfOrderBetween(Date fromDate, Date toDate);
}
