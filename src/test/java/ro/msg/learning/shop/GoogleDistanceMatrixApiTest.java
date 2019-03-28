package ro.msg.learning.shop;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import ro.msg.learning.entity.Address;
import ro.msg.learning.entity.Location;
import ro.msg.learning.repository.dao.LocationRepository;
import ro.msg.learning.service.strategy.concrete.ClosestLocation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

/**
 * Created by vancer at 3/11/2019
 */
@RunWith(MockitoJUnitRunner.class)
public class GoogleDistanceMatrixApiTest {

    @Mock
    private LocationRepository locationRepository;

    @Mock
    private Environment environment;

    @InjectMocks
    public ClosestLocation closestLocation;


    /**
     * Simple test, where we give 2 locations and see which one is the closest to the delivery address.
     */
    @Test
    public void establishLocationTest() {

        Map<Long, Integer> productsIdQuantityMap = new HashMap<>();
        Location location1 = new Location(null, null, new Address("Romania", "Cluj-Napoca", "Cluj", "3 Ion Pop Reteganu"), null, null);
        Location location2 = new Location(null, null, new Address("Romania", "Floresti", "Cluj", "1 Eroilor"), null, null);
        Address deliveryAddress = new Address("Romania", "Cluj-Napoca", "Cluj", "7 Brassai Samuel");

        when(environment.getProperty("googleDistanceMatrxUrl")).thenReturn("https://maps.googleapis.com/maps/api/" +
                "distancematrix/json?origins={stockLocationAddressString}&destinations={deliveryAddressString}&key={googleApiKey}");
        when(locationRepository.findLocationsWithAllProductsAndQuantityInStock(productsIdQuantityMap)).thenReturn(Arrays.asList(location2, location1));
        when(environment.getProperty("GoogleApiKey")).thenReturn(System.getProperty("googleApiKey"));

        Assert.assertEquals(closestLocation.establishLocation(productsIdQuantityMap, deliveryAddress), location1);
    }
}
