package com.api.restapifactorydatabase.controller;


import com.api.restapifactorydatabase.model.Order;
import com.api.restapifactorydatabase.service.Impl.OrderServiceImpl;
import com.api.restapifactorydatabase.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping(value = "",consumes="application/json")
    public ResponseEntity saveOrders(@RequestBody Order order) {
        orderService.save(order);
        return  ResponseEntity.ok(HttpStatus.OK);
    }

}
