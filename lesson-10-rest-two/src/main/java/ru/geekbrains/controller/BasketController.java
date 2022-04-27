package ru.geekbrains.controller;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.model.Product;
import ru.geekbrains.service.impl.BasketServiceImpl;
import ru.geekbrains.service.impl.ProductServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/basket/{basketId}")
public class BasketController {

    private BasketServiceImpl basketServiceImpl;

    public BasketController(BasketServiceImpl basketServiceImpl) {
        this.basketServiceImpl = basketServiceImpl;
    }

    @GetMapping("/product/{productId}")
    public boolean addProduct(@PathVariable Long basketId, @PathVariable Long productId) {
        return basketServiceImpl.addProduct(basketId, productId);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(@PathVariable Long basketId) {
        return basketServiceImpl.findAllProducts(basketId);
    }

    @DeleteMapping("/product/{productId}")
    public boolean deleteProduct(@PathVariable Long basketId, @PathVariable Long productId) {
        return basketServiceImpl.deleteProduct(basketId, productId);
    }

    @DeleteMapping("/products")
    public boolean deleteAllProducts(@PathVariable Long basketId) {
        return basketServiceImpl.deleteAllProducts(basketId);
    }

}
