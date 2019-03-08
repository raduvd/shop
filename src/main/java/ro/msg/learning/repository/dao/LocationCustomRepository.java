package ro.msg.learning.repository.dao;

import ro.msg.learning.entity.Location;

import java.util.List;
import java.util.Map;

/**
 * Created by vancer at 2/19/2019
 */

public interface LocationCustomRepository {

    public List<Location> findLocationsWithAllProductsAndQuantityInStock(Map<Long, Integer> productsIdQuantityMap);

}
