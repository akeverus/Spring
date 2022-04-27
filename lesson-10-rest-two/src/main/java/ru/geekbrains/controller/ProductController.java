package ru.geekbrains.controller;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.model.Product;
import ru.geekbrains.service.impl.ProductServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productServiceImpl.create(product);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productServiceImpl.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productServiceImpl.delete(id);
    }

    @GetMapping("/list")
    public List<Product> findAll() {
        return productServiceImpl.findAll();
    }
}
