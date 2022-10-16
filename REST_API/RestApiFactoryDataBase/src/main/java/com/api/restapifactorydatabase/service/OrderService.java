package com.api.restapifactorydatabase.service;

import com.api.restapifactorydatabase.model.Order;

import java.util.List;

public interface OrderService {
    Order getById(Integer id);
    List<Order> getAll();
}
