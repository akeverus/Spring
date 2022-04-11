package ru.geekbrains.persist;

import javax.validation.constraints.*;
import java.util.Objects;

public class Product {

    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "100000.0")
    private Double cost;

    public Product(String title, Double cost) {
        this.title = title;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id.equals(product.id) && title.equals(product.title) && cost.equals(product.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, cost);
    }
}
