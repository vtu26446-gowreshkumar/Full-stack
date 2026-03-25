package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    // Task 6.1 → Add product
    @PostMapping
    public Product addProduct(@RequestBody Product p) {
        return service.addProduct(p);
    }

    // Task 6.1 → Get all
    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAll();
    }

    // Task 6.2 → Get by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getById(id);
    }

    // Task 6.3 → Update
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product p) {
        return service.update(id, p);
    }

    // Task 6.3 → Delete
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.delete(id);
    }
}