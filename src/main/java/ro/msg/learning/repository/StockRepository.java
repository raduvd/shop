package ro.msg.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.entity.Stock;
import ro.msg.learning.entity.composite.StockCompositeKey;

/**
 * Created by vancer at 2/19/2019
 */

public interface StockRepository extends JpaRepository<Stock, StockCompositeKey> {
}
