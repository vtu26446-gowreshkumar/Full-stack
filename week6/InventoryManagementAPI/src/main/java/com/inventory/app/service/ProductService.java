package com.inventory.app.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.inventory.app.model.Product;

@Service
public class ProductService {

    private List<Product> list = new ArrayList<>();

    public Product addProduct(Product p) {
        list.add(p);
        return p;
    }

    public List<Product> getAll() {
        return list;
    }

    public Product getById(int id) {
        return list.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

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

    public String delete(int id) {
        list.removeIf(p -> p.getId() == id);
        return "Deleted Successfully";
    }
}