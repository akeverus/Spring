package ru.geekbrains.service;

import ru.geekbrains.model.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product findById(Long id);
    void delete(Long id);
    public List<Product> findAll();
}
