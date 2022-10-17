package com.api.restapifactorydatabase.controller;

import com.api.restapifactorydatabase.model.Product;
import com.api.restapifactorydatabase.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products/")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }
    @GetMapping(path = "{id}")
    public Product getProductById(@PathVariable(name = "id") Long id) {
        return productService.getById(id);
    }
    @PostMapping(path = "")
    public ResponseEntity saveProduct(@RequestBody Product product) {
        productService.save(product);
        return  ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping(path = "{id}")
    public ResponseEntity deleteProduct(@PathVariable(name = "id") Long id) {
        productService.delete(id);
        return  ResponseEntity.ok(HttpStatus.OK);
    }
}
