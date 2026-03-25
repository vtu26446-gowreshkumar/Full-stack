package com.example.demo.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.example.demo.model.Product;

@Service
public class ProductService {

    private List<Product> list = new ArrayList<>();

    // Add product
    public Product addProduct(Product p) {
        list.add(p);
        return p;
    }

    // Get all products
    public List<Product> getAll() {
        return list;
    }

    // Get product by ID
    public Product getById(int id) {
        return list.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Update product
    public Product update(int id, Product newP) {
        for (Product p : list) {
            if (p.getId() == id) {
                p.setName(newP.getName());
                p.setPrice(newP.getPrice());
                return p;
            }
        }
        return null;
    }

    // Delete product
    public String delete(int id) {
        list.removeIf(p -> p.getId() == id);
        return "Deleted Successfully";
    }
}