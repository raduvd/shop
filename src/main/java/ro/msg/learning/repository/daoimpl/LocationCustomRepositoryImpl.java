package ro.msg.learning.repository.daoimpl;

import ro.msg.learning.entity.Location;
import ro.msg.learning.entity.Stock;
import ro.msg.learning.repository.dao.LocationCustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by vancer at 2/28/2019
 */
public class LocationCustomRepositoryImpl implements LocationCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Uses JPA Criteria to create a Dynamic Query
     *
     * @param productsIdQuantityMap
     * @return
     */
    public List<Location> findLocationsWithAllProductsAndQuantityInStock(Map<Long, Integer> productsIdQuantityMap) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Location> query = criteriaBuilder.createQuery(Location.class);
        Root<Location> location = query.from(Location.class);
        final Join<Location, Stock> locationStockJoin = location.join("stockList");

        Path<Integer> quantityFromLocationStock = locationStockJoin.get("quantity");
        Path<Long> productIdFromLocationStock = locationStockJoin.get("stockCompositeKey").get("product").get("id");
        Path<Long> locationId = location.get("id");

        List<Predicate> predicateList = new ArrayList<>();

        productsIdQuantityMap.keySet().forEach(productId -> {
            predicateList.add(criteriaBuilder.and(criteriaBuilder.equal(productIdFromLocationStock, productId),
                    criteriaBuilder.greaterThanOrEqualTo(quantityFromLocationStock, productsIdQuantityMap.get(productId))));
        });

        //Mock: Select * from Location where [product id = mapKey AND quantity = mapValue] GROUP BY locationId HAVING COUNT (productId) = mapSize
        query.multiselect(location).where(criteriaBuilder.or(predicateList.toArray(new Predicate[predicateList.size()]))).
                groupBy(locationId).having(criteriaBuilder.equal(criteriaBuilder.count(productIdFromLocationStock), productsIdQuantityMap.size()));
        return entityManager.createQuery(query).getResultList();
    }
}
