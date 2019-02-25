package ro.msg.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.msg.learning.entity.Location;
import ro.msg.learning.entity.Product;
import ro.msg.learning.entity.composite.StockCompositeKey;
import ro.msg.learning.repository.LocationRepository;
import ro.msg.learning.repository.ProductRepository;
import ro.msg.learning.repository.StockRepository;

/**
 * Created by vancer at 2/19/2019
 */
@Component
public class Test {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private LocationRepository locationRepository;

    public String test(Long id) {

        final Product product = productRepository.getOne(id);

        final Location location = locationRepository.getOne(id);

        return stockRepository.getOne(new StockCompositeKey(product, location)).toString();
    }
}
