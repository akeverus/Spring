package ru.geekbrains.service.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.exception.ProductNotFoundException;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.ProductRepository;
import ru.geekbrains.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product findById(Long id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        if (foundProduct.isPresent()) {
            return foundProduct.get();
        } else {
            throw new ProductNotFoundException("Product don't found");
        }
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

}
