package ro.msg.learning.controller;

/**
 * Created by vancer at 2/18/2019
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.entity.Order;
import ro.msg.learning.exception.OrderValidationException;
import ro.msg.learning.service.OrderService;
import ro.msg.learning.transitionobject.OrderTO;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {

        this.orderService = orderService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public @ResponseBody
    Order createOrder(@Valid @RequestBody OrderTO orderTO, Errors errors) {

        if (errors.hasErrors())
            throw new OrderValidationException(errors);

        return orderService.createOrder(orderTO);
    }
}