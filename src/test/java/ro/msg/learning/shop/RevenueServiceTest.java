package ro.msg.learning.shop;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import ro.msg.learning.entity.Location;
import ro.msg.learning.entity.Order;
import ro.msg.learning.entity.OrderDetail;
import ro.msg.learning.entity.Product;
import ro.msg.learning.entity.composite.OrderDetailCompositeKey;
import ro.msg.learning.service.RevenueService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by vancer at 3/12/2019
 */
@RunWith(MockitoJUnitRunner.class)
public class RevenueServiceTest {

    @InjectMocks
    private RevenueService revenueService;

    @Test
    public void mapOrderListByLocationTest() {

        Assert.assertTrue(revenueService.mapOrderListByLocation(Arrays.asList(
                new Order(1L, new Location(1L), null, new Date(), null, null),
                new Order(2L, new Location(1L), null, new Date(), null, null),
                new Order(3L, new Location(2L), null, new Date(), null, null))).size() == 2);

    }

    @Test
    public void calculatePriceSumForLocationTest() {

        Assert.assertTrue(revenueService.calculatePriceSumForLocation(Arrays.asList(
                createOrder(), createOrder())).toString().equals("32.399999999999998578914528479799628257751464843750"));
    }

    private OrderDetail createOrderDetail(BigDecimal productPrice, Integer orderQuantity) {

        Product product = new Product();
        product.setPrice(productPrice);

        OrderDetailCompositeKey orderDetailCompositeKey = new OrderDetailCompositeKey();
        orderDetailCompositeKey.setProduct(product);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderQuantity(orderQuantity);
        orderDetail.setOrderDetailCompositeKey(orderDetailCompositeKey);

        return orderDetail;
    }

    private Order createOrder() {

        Order order = new Order();
        order.setOrderDetailList(Arrays.asList(
                createOrderDetail(new BigDecimal(2.4), 5),
                createOrderDetail(new BigDecimal(1.4), 3)));

        return order;
    }
}

