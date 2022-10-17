package com.api.restapifactorydatabase.repository;

import com.api.restapifactorydatabase.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
