package com.api.restapifactorydatabase.service.Impl;

import com.api.restapifactorydatabase.model.Order;
import com.api.restapifactorydatabase.repository.OrderRepository;
import com.api.restapifactorydatabase.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getById(Long id) {
        Order result = orderRepository.findById(id).orElse(null);

        if (result == null) {
            System.out.println("IN findById - no user found by id: {}" +  id);
            return null;
        }

        System.out.println("IN findById - user: {} found by id: {}" + result.toString());
        return result;
    }

    @Override
    public List<Order> getAll() {
        List<Order> result = orderRepository.findAll();
        return result;
    }
}
