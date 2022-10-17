package com.api.restapifactorydatabase.service;

import com.api.restapifactorydatabase.model.Material;
import com.api.restapifactorydatabase.model.Order;

import java.util.List;

public interface OrderService {
    Order getById(Long id);
    List<Order> getAll();

    Order save(Order order) ;
}
