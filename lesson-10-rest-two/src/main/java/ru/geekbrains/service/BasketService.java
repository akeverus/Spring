package ru.geekbrains.service;

import ru.geekbrains.model.Product;

import java.util.List;

public interface BasketService {
    boolean addProduct(Long basketId, Long productId);
    boolean deleteProduct(Long basketId, Long productId);
    boolean deleteAllProducts(Long basketId);
    public List<Product> findAllProducts(Long basketId);
}
