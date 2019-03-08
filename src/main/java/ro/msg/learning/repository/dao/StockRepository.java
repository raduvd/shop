package ro.msg.learning.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.entity.Stock;
import ro.msg.learning.entity.composite.StockCompositeKey;

import java.util.List;

/**
 * Created by vancer at 2/19/2019
 */

public interface StockRepository extends JpaRepository<Stock, StockCompositeKey> {

    List<Stock> getStocksByStockCompositeKey_Location_Id(Long locationId);
}
