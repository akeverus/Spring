package ru.geekbrains.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.model.Product;

import java.util.Arrays;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAllByIdIsIn(List<Long> ids);
}
