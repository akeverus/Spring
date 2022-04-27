package ru.geekbrains.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.model.Basket;
import ru.geekbrains.model.Product;

@Repository
public interface BasketRepository extends CrudRepository<Basket, Long> {
}
