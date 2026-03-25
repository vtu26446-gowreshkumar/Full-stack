package com.inventory.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.*;

import com.inventory.app.model.Product;
import com.inventory.app.model.User;
import com.inventory.app.service.ProductService;

@RestController
@RequestMapping("/items")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product p) {
        return ResponseEntity.status(201).body(service.addProduct(p));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody User user) {
        return ResponseEntity.ok("User Registered");
    }
}