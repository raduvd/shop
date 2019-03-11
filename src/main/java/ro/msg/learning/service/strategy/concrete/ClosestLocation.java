package ro.msg.learning.service.strategy.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ro.msg.learning.entity.Address;
import ro.msg.learning.entity.Location;
import ro.msg.learning.exception.GoogleDistanceMatrixException;
import ro.msg.learning.exception.LocationNotFoundException;
import ro.msg.learning.repository.dao.LocationRepository;
import ro.msg.learning.service.strategy.LocationStrategy;
import ro.msg.learning.transitionobject.google.GoogleDistanceMatrixApiResponse;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by vancer at 2/28/2019
 */
@Component
@Primary
public class ClosestLocation implements LocationStrategy {

    private LocationRepository locationRepository;

    private RestTemplate restTemplate;

    private Environment environment;

    @Autowired
    public ClosestLocation(LocationRepository locationRepository, Environment environment) {

        this.locationRepository = locationRepository;
        this.restTemplate = new RestTemplate();
        this.environment = environment;
    }

    @Override
    public Location establishLocation(Map<Long, Integer> productsIdQuantityMap, Address deliveryAddress) {

        final List<Location> locationsWithAllProductsAndQuantityInStock =
                locationRepository.findLocationsWithAllProductsAndQuantityInStock(productsIdQuantityMap);

        if (locationsWithAllProductsAndQuantityInStock.isEmpty())
            throw new LocationNotFoundException();

        TreeMap<GoogleDistanceMatrixApiResponse, Location> locationDistanceMap = new TreeMap<>();

        for (Location stockLocation : locationsWithAllProductsAndQuantityInStock) {

            final String deliveryAddressString = deliveryAddress.toString();
            final String stockLocationAddressString = stockLocation.getAddress().toString();
            final String googleApiKey = environment.getProperty("GoogleApiKey");

            String url = "https://maps.googleapis.com/maps/api/distancematrix/json?"
                    + "origins=" + stockLocationAddressString
                    + "&destinations=" + deliveryAddressString
                    + "&key=" + googleApiKey;

            final ResponseEntity<GoogleDistanceMatrixApiResponse> forEntity = restTemplate.getForEntity(url, GoogleDistanceMatrixApiResponse.class);

            if (forEntity.getStatusCode().equals(HttpStatus.OK)) {
                validateGoogleDistanceMatrixApiResponse(forEntity.getBody());
                locationDistanceMap.put(forEntity.getBody(), stockLocation);
            } else {
                throw new GoogleDistanceMatrixException(forEntity.getStatusCode().getReasonPhrase());
            }
        }

        return locationDistanceMap.firstEntry().getValue();
    }

    private void validateGoogleDistanceMatrixApiResponse(GoogleDistanceMatrixApiResponse response) {

        if (response.getRows().isEmpty()
                || response.getRows().get(0).getElements().isEmpty()
                || response.getRows().get(0).getElements().get(0).getDistance() == null
                || response.getRows().get(0).getElements().get(0).getDistance().getValue() == null)

            throw new GoogleDistanceMatrixException("Server response from Google Distance Matrix Api does not contain valid information.");
    }
}

