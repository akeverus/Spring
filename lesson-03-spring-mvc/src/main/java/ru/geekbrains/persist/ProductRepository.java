package ru.geekbrains.persist;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {

    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            this.save(new Product("Product " + i, Math.random() * 1000 * i));
        }
    }

    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public Product findById(long id) {
        return productMap.get(id);
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(identity.incrementAndGet());
        }
        productMap.put(product.getId(), product);
        return product;
    }

    public void delete(long id) {
        productMap.remove(id);
    }

}
