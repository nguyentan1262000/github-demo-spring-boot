package com.example.product.service;

import com.example.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    void save(Product product);
    Product getById(Integer id);
    void deleteViaId(Integer id);
    void update(Integer id, Product product);
}
