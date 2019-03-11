package ro.msg.learning.service.strategy.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.msg.learning.entity.Address;
import ro.msg.learning.entity.Location;
import ro.msg.learning.service.strategy.LocationStrategy;

import java.util.Map;

/**
 * Created by vancer at 2/28/2019
 */
@Component
public class LocationStrategyContext {

    private LocationStrategy locationStrategy;

    @Autowired
    public LocationStrategyContext(LocationStrategy locationStrategy) {

        this.locationStrategy = locationStrategy;
    }

    public Location establishLocation(Map<Long, Integer> productsIdQuantityMap, Address deliveryAddress) {
        return locationStrategy.establishLocation(productsIdQuantityMap, deliveryAddress);
    }
}
