package com.api.restapifactorydatabase.service;

import com.api.restapifactorydatabase.model.Material;
import com.api.restapifactorydatabase.model.Order;
import com.api.restapifactorydatabase.model.Product;

import java.util.List;

public interface ProductService {
    Product getById(Long id);
    List<Product> getAll();
    Product save(Product product);
    void delete(Long id);
}
