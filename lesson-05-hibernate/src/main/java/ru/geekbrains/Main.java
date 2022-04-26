package ru.geekbrains;

import ru.geekbrains.model.Employee;
import ru.geekbrains.model.Product;
import ru.geekbrains.service.EmployeeService;
import ru.geekbrains.service.ProductService;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        EmployeeService employeeService = new EmployeeService();

        Product product1 = new Product( "Product 1", 100000.0);
        Product product2 = new Product( "Product 2", 200000.0);
        Product product3 = new Product( "Product 3", 300000.0);

        Set<Product> products1 = new HashSet<>(Arrays.asList(product1, product2));
        Set<Product> products2 = new HashSet<>(Arrays.asList(product2, product3));

        Employee employee1 = new Employee(products1);
        Employee employee2 = new Employee(products2);

        System.out.println("*** Persist - start ***");
        employeeService.persist(employee1);
        employeeService.persist(employee2);
        List<Product> products3 = productService.findAll();
        System.out.println("Products Persisted are :");
        for (Product b : products3) {
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
        List<Product> products4 = productService.findAll();
        System.out.println("Products found are :");
        for (Product b : products4) {
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
