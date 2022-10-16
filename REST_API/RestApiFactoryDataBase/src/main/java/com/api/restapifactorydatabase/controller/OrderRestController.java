package com.api.restapifactorydatabase.controller;


import com.api.restapifactorydatabase.model.Order;
import com.api.restapifactorydatabase.service.Impl.OrderServiceImpl;
import com.api.restapifactorydatabase.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders/")
public class OrderRestController {
    private final OrderService orderService;
    @Autowired
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping(value = "{id}")
    public Order getOrderById(@PathVariable(name = "id") Long id) {
        return orderService.getById(id);

    }
    @GetMapping(value = "")
    public List<Order> getAllOrders() {
        return orderService.getAll();
    }

}
