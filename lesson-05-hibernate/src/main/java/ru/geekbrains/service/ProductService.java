package ru.geekbrains.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.dao.impl.ProductDaoImpl;
import ru.geekbrains.model.Product;

import java.util.List;

@Service
public class ProductService {

    private static ProductDaoImpl productDaoImpl;

    public ProductService() {
        productDaoImpl = new ProductDaoImpl();
    }

    public void persist(Product entity) {
        productDaoImpl.openCurrentSessionWithTransaction();
        productDaoImpl.persist(entity);
        productDaoImpl.closeCurrentSessionWithTransaction();
    }

    public void update(Product entity) {
        productDaoImpl.openCurrentSessionWithTransaction();
        productDaoImpl.update(entity);
        productDaoImpl.closeCurrentSessionWithTransaction();
    }

    public Product findById(Long id) {
        productDaoImpl.openCurrentSession();
        Product product = productDaoImpl.findById(id);
        productDaoImpl.closeCurrentSession();
        return product;
    }

    public void delete(Long id) {
        productDaoImpl.openCurrentSessionWithTransaction();
        Product product = productDaoImpl.findById(id);
        productDaoImpl.delete(product);
        productDaoImpl.closeCurrentSessionWithTransaction();
    }

    public List<Product> findAll() {
        productDaoImpl.openCurrentSession();
        List<Product> products = productDaoImpl.findAll();
        productDaoImpl.closeCurrentSession();
        return products;
    }

    public void deleteAll() {
        productDaoImpl.openCurrentSessionWithTransaction();
        productDaoImpl.deleteAll();
        productDaoImpl.closeCurrentSessionWithTransaction();
    }

    public ProductDaoImpl productDao() {
        return productDaoImpl;
    }
}
