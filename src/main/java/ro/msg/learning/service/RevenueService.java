package ro.msg.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ro.msg.learning.entity.Location;
import ro.msg.learning.entity.Order;
import ro.msg.learning.entity.OrderDetail;
import ro.msg.learning.entity.Revenue;
import ro.msg.learning.repository.dao.OrderRepository;
import ro.msg.learning.repository.dao.RevenueRepository;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by vancer at 3/1/2019
 */
@Service
public class RevenueService {

    private OrderRepository orderRepository;

    private RevenueRepository revenueRepository;

    @Autowired
    public RevenueService(OrderRepository orderRepository, RevenueRepository revenueRepository) {

        this.orderRepository = orderRepository;
        this.revenueRepository = revenueRepository;
    }

    //Server timezone, 1 AM each day
    @Scheduled(cron = "0 0 1 * * *")
    public void aggregateSales() {

        Calendar date = new GregorianCalendar();
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);

        Date todayMidnight = date.getTime();
        date.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterdayMidnight = date.getTime();

        final List<Order> orderList = orderRepository.getByDateOfOrderBetween(yesterdayMidnight, todayMidnight);

        final Map<Location, List<Order>> locationIdOrderMap = mapOrderListByLocation(orderList);

        for (Location location : locationIdOrderMap.keySet()) {

            Revenue revenue = new Revenue();
            revenue.setDate(todayMidnight);
            revenue.setLocation(location);
            revenue.setSum(calculatePriceSumForLocation(locationIdOrderMap.get(location)));

            revenueRepository.save(revenue);
        }
    }

    public BigDecimal calculatePriceSumForLocation(List<Order> orderList) {

        BigDecimal priceSumForLocation = new BigDecimal(0);

        for (Order order : orderList) {

            for (OrderDetail orderDetail : order.getOrderDetailList()) {

                final BigDecimal price = orderDetail.getOrderDetailCompositeKey().getProduct().getPrice();
                final Integer quantity = orderDetail.getOrderQuantity();
                final BigDecimal priceSumForProduct = BigDecimal.valueOf(price.doubleValue() * quantity);
                priceSumForLocation = priceSumForLocation.add(priceSumForProduct);
            }
        }
        return priceSumForLocation;
    }


    public Map<Location, List<Order>> mapOrderListByLocation(List<Order> orderList) {

        Map<Location, List<Order>> locationOrderListMap = new HashMap();

        for (Order order : orderList) {

            final Location mapKey = order.getShippedFromLocation();

            final List<Order> newLocationOrderList = new ArrayList<>();
            newLocationOrderList.add(order);

            final List<Order> existingLocationOrderList = locationOrderListMap.putIfAbsent(mapKey, newLocationOrderList);
            if (existingLocationOrderList != null)
                existingLocationOrderList.add(order);
        }
        return locationOrderListMap;
    }
}
