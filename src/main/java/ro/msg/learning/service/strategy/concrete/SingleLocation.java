package ro.msg.learning.service.strategy.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.msg.learning.entity.Address;
import ro.msg.learning.entity.Location;
import ro.msg.learning.exception.LocationNotFoundException;
import ro.msg.learning.repository.dao.LocationRepository;
import ro.msg.learning.service.strategy.LocationStrategy;

import java.util.List;
import java.util.Map;

/**
 * Created by vancer at 2/28/2019
 */
@Component
public class SingleLocation implements LocationStrategy {

    private LocationRepository locationRepository;

    @Autowired
    public SingleLocation(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location establishLocation(Map<Long, Integer> productsIdQuantityMap, Address deliveryAddress) {

        final List<Location> locationsWithAllProductsAndQuantityInStock =
                locationRepository.findLocationsWithAllProductsAndQuantityInStock(productsIdQuantityMap);

        if (locationsWithAllProductsAndQuantityInStock.isEmpty())
            throw new LocationNotFoundException();

        return locationsWithAllProductsAndQuantityInStock.get(0);
    }
}
