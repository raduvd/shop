package ro.msg.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.entity.*;
import ro.msg.learning.entity.composite.OrderDetailCompositeKey;
import ro.msg.learning.repository.dao.CustomerRepository;
import ro.msg.learning.repository.dao.OrderDetailRepository;
import ro.msg.learning.repository.dao.OrderRepository;
import ro.msg.learning.repository.dao.StockRepository;
import ro.msg.learning.service.strategy.context.LocationStrategyContext;
import ro.msg.learning.transitionobject.OrderTO;

/**
 * Created by vancer at 2/19/2019
 */
@Service
public class OrderService {


    private LocationStrategyContext locationStrategyContext;

    private StockRepository stockRepository;

    private OrderDetailRepository orderDetailRepository;

    private OrderRepository orderRepository;

    private CustomerRepository customerRepository;

    @Autowired
    public OrderService(LocationStrategyContext locationStrategyContext, StockRepository stockRepository,
                        OrderDetailRepository orderDetailRepository, OrderRepository orderRepository,
                        CustomerRepository customerRepository) {

        this.locationStrategyContext = locationStrategyContext;
        this.stockRepository = stockRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public Order createOrder(OrderTO orderTO) {

        final Location location = locationStrategyContext.establishLocation(orderTO.getProductIdQuantityMap());

        Order order = new Order();
        order.setShippedFromLocation(location);
        order.setCustomer(customerRepository.getOne(1l));

        Address address = new Address();
        address.setCity(orderTO.getCity());
        address.setCountry(orderTO.getCountry());
        address.setCounty(orderTO.getCounty());
        address.setStreetAddress(orderTO.getStreetAddress());
        order.setAddress(address);

        final Order persistedOrder = orderRepository.save(order);

        //iterate over all products from user orderTO
        for (Long productId : orderTO.getProductIdQuantityMap().keySet()) {
            for (Stock stock : location.getStockList())
                //find the stock with the current product
                if (stock.getStockCompositeKey().getProduct().getId().equals(productId)) {

                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setOrderQuantity(stock.getQuantity());
                    OrderDetailCompositeKey orderDetailCompositeKey = new OrderDetailCompositeKey();
                    orderDetailCompositeKey.setProduct(stock.getStockCompositeKey().getProduct());
                    orderDetailCompositeKey.setShopOrder(persistedOrder);
                    orderDetail.setOrderDetailCompositeKey(orderDetailCompositeKey);
                    orderDetailRepository.save(orderDetail);

                    //substract product
                    stock.setQuantity(stock.getQuantity() - orderTO.getProductIdQuantityMap().get(productId));
                    stockRepository.save(stock);
                }
        }

        return orderRepository.getOne(persistedOrder.getId());
    }
}


