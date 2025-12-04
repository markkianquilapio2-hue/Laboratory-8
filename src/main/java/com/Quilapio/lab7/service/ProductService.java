package com.Quilapio.lab7.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import com.Quilapio.lab7.model.Product;

@Service
public class ProductService {

    private final List<Product> inventory = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong(4); // Start after mock products

    public ProductService() {
        // Initialize with at least three mock products
        inventory.add(new Product(1L, "Laptop Pro", 1999.99));
        inventory.add(new Product(2L, "Wireless Mouse", 25.00));
        inventory.add(new Product(3L, "Monitor 4K", 450.50));
    }

    // READ ALL Products
    public List<Product> findAll() {
        return inventory;
    }

    // READ ONE Product
    public Optional<Product> findById(Long id) {
        return inventory.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    // CREATE a new Product
    public Product create(Product product) {
        product.setId(nextId.getAndIncrement());
        inventory.add(product);
        return product;
    }

    // UPDATE an existing Product
    public Optional<Product> update(Long id, Product updatedProduct) {
        Optional<Product> existingProduct = findById(id);

        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            return Optional.of(product);
        } else {
            return Optional.empty();
        }
    }

    // DELETE a Product
    public boolean delete(Long id) {
        return inventory.removeIf(p -> p.getId().equals(id));
    }
}