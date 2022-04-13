package ru.geekbrains;

import ru.geekbrains.model.Product;
import ru.geekbrains.service.ProductService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Product product1 = new Product( 1L, "Product 1", 100000.0);
        Product product2 = new Product( 2L, "Product 2", 200000.0);
        Product product3 = new Product( 3L, "Product 3", 300000.0);
        System.out.println("*** Persist - start ***");
        productService.persist(product1);
        productService.persist(product2);
        productService.persist(product3);
        List<Product> products1 = productService.findAll();
        System.out.println("Products Persisted are :");
        for (Product b : products1) {
            System.out.println("-" + b.toString());
        }
        System.out.println("*** Persist - end ***");
        System.out.println("*** Update - start ***");
        product1.setTitle("Product 1");
        productService.update(product1);
        System.out.println("Product Updated is =>" +productService.findById(product1.getId()).toString());
        System.out.println("*** Update - end ***");
        System.out.println("*** Find - start ***");
        Long id1 = product1.getId();
        Product another = productService.findById(id1);
        System.out.println("Product found with id " + id1 + " is =>" + another.toString());
        System.out.println("*** Find - end ***");
        System.out.println("*** Delete - start ***");
        Long id3 = product3.getId();
        productService.delete(id3);
        System.out.println("Deleted product with id " + id3 + ".");
        System.out.println("Now all products are " + productService.findAll().size() + ".");
        System.out.println("*** Delete - end ***");
        System.out.println("*** FindAll - start ***");
        List<Product> products2 = productService.findAll();
        System.out.println("Products found are :");
        for (Product b : products2) {
            System.out.println("-" + b.toString());
        }
        System.out.println("*** FindAll - end ***");
        System.out.println("*** DeleteAll - start ***");
        productService.deleteAll();
        System.out.println("Products found are now " + productService.findAll().size());
        System.out.println("*** DeleteAll - end ***");
        System.exit(0);
    }
}
