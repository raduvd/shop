package ro.msg.learning.service.strategy;

import org.springframework.stereotype.Component;
import ro.msg.learning.entity.Address;
import ro.msg.learning.entity.Location;

import java.util.Map;

/**
 * Created by vancer at 2/28/2019
 */

public interface LocationStrategy {

    public Location establishLocation(Map<Long, Integer> productsIdQuantityMap, Address deliveryAddress);
}
