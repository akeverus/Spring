package ru.geekbrains.dao.impl;

import org.springframework.stereotype.Repository;
import ru.geekbrains.dao.HibernateDao;
import ru.geekbrains.dao.config.HibernateUtil;
import ru.geekbrains.model.Product;

import java.util.List;

@Repository
public class ProductDaoImpl extends HibernateUtil implements HibernateDao<Product, Long> {

    public ProductDaoImpl() {
    }

    public void persist(Product entity) {
        getCurrentSession().save(entity);
    }

    public void update(Product entity) {
        getCurrentSession().update(entity);
    }

    public Product findById(Long id) {
        Product product = getCurrentSession().get(Product.class, id);
        return product;
    }

    public void delete(Product entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Product> findAll() {
        List<Product> products = (List<Product>) getCurrentSession().createQuery("from Product").list();
        return products;
    }

    public void deleteAll() {
        List<Product> entityList = findAll();
        for (Product entity : entityList) {
            delete(entity);
        }
    }
}
