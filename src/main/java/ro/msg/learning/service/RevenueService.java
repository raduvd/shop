package ro.msg.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.msg.learning.entity.Location;
import ro.msg.learning.entity.Order;
import ro.msg.learning.entity.Revenue;
import ro.msg.learning.repository.dao.OrderRepository;
import ro.msg.learning.repository.dao.RevenueRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by vancer at 3/1/2019
 */
@Service
@Transactional
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

        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDateTime todayMidnight = LocalDateTime.of(LocalDate.now(), midnight);
        LocalDateTime yesterdayMidnight = todayMidnight.minusDays(1l);

        final List<Order> orderList = orderRepository.getByDateOfOrderBetween(yesterdayMidnight, todayMidnight);

        final Map<Location, List<Order>> locationIdOrderMap = mapOrderListByLocation(orderList);

        locationIdOrderMap.keySet().forEach(location -> {
            Revenue revenue = new Revenue();
            revenue.setDate(todayMidnight);
            revenue.setLocation(location);
            revenue.setSum(calculatePriceSumForLocation(locationIdOrderMap.get(location)));
            revenueRepository.save(revenue);
        });
    }

    public BigDecimal calculatePriceSumForLocation(List<Order> orderList) {

        BigDecimal[] priceSumForLocation = {BigDecimal.ZERO};

        orderList.forEach(order -> {
            order.getOrderDetailList().forEach(orderDetail -> {
                final BigDecimal price = orderDetail.getOrderDetailCompositeKey().getProduct().getPrice();
                final Integer quantity = orderDetail.getOrderQuantity();
                final BigDecimal priceSumForProduct = price.multiply(BigDecimal.valueOf(quantity));
                priceSumForLocation[0] = priceSumForLocation[0].add(priceSumForProduct);
            });
        });
        return priceSumForLocation[0];
    }


    public Map<Location, List<Order>> mapOrderListByLocation(List<Order> orderList) {

        Map<Location, List<Order>> locationOrderListMap =
                orderList.stream().collect(Collectors.groupingBy(Order::getShippedFromLocation));

        return locationOrderListMap;
    }
}
