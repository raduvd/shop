package ro.msg.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.entity.Stock;
import ro.msg.learning.repository.dao.StockRepository;

import java.util.List;

/**
 * Created by vancer at 3/1/2019
 */
@Service
public class StockService {

    private StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {

        this.stockRepository = stockRepository;
    }

    public List<Stock> exportStock(Long locationId) {

        return stockRepository.getStocksByStockCompositeKey_Location_Id(locationId);
    }
}
