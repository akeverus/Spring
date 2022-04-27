package ru.geekbrains.service.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.exception.BasketNotFoundException;
import ru.geekbrains.model.Basket;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.BasketRepository;
import ru.geekbrains.repository.ProductRepository;
import ru.geekbrains.service.BasketService;

import java.util.List;
import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {

    private BasketRepository basketRepository;
    private ProductRepository productRepository;

    public BasketServiceImpl(BasketRepository basketRepository, ProductRepository productRepository) {
        this.basketRepository = basketRepository;
        this.productRepository = productRepository;
    }

    @Override
    public boolean addProduct(Long basketId, Long productId) {
        Optional<Basket> foundBasket = basketRepository.findById(basketId);
        if (foundBasket.isPresent()) {
            Basket basket = foundBasket.get();
            if (productRepository.existsById(productId)) {
                basket.addProduct(productId);
                return true;
            } else {
                throw new BasketNotFoundException("Product don't found");
            }
        } else {
            throw new BasketNotFoundException("Basket don't found");
        }
    }

    @Override
    public boolean deleteProduct(Long basketId, Long productId) {
        Optional<Basket> foundBasket = basketRepository.findById(basketId);
        if (foundBasket.isPresent()) {
            Basket basket = foundBasket.get();
            if (productRepository.existsById(productId) && basket.getProducts().contains(productId)) {
                basket.deleteProduct(productId);
                return true;
            } else {
                throw new BasketNotFoundException("Product don't found");
            }
        } else {
            throw new BasketNotFoundException("Basket don't found");
        }
    }

    @Override
    public boolean deleteAllProducts(Long basketId) {
        Optional<Basket> foundBasket = basketRepository.findById(basketId);
        if (foundBasket.isPresent()) {
            Basket basket = foundBasket.get();
            basket.getProducts().clear();
            return true;
        } else {
            throw new BasketNotFoundException("Basket don't found");
        }
    }

    @Override
    public List<Product> findAllProducts(Long basketId) {
        Optional<Basket> foundBasket = basketRepository.findById(basketId);
        if (foundBasket.isPresent()) {
            Basket basket = foundBasket.get();
            return productRepository.findAllByIdIsIn(basket.getProducts());
        } else {
            throw new BasketNotFoundException("Basket don't found");
        }
    }
}
