import domain.enumm.ProductCategory;
import domain.initializer.DataInitializer;
import domain.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Order order = DataInitializer.initializeOrder();
        List<Product> products = DataInitializer.initializeProducts();
        List<Customer> customers =  DataInitializer.initializeCustomer();
        List<Order> orders = (List<Order>) DataInitializer.initializeOrder();

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 4) {
            System.out.println("Menú");
            System.out.println("1. Order");
            System.out.println("2. Products");
            System.out.println("3. Customer");
            System.out.println("4. Productos filtrados por categoria y precio");
            System.out.println("5. Exit");
            System.out.print("Option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    displayOrder(order);
                    break;
                case 2:
                    displayProducts(order);
                    break;
                case 3:
                    displayCustomer((Customer) orders);
                    break;
                case 4: getFilteredProducts(products);
                case 10:
                    System.out.println("Thank you, bye.");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        scanner.close();
    }

    private static List<Product> getFilteredProducts(List<Product> products) {
        String categoria ="libros";
        return products.stream()
                .filter(e->e.getCategory().equals(ProductCategory.fromValue(categoria)))
                .filter(e->e.getPrice()>100)
                .toList();

    }

    public static void displayOrder(Order order) {

        System.out.println("------------------------");
        System.out.println("Order:");
        System.out.println("ID: " + order.getId());
        System.out.println("Status: " + order.getStatus());
        System.out.println("Order Date: " + order.getOrderDate());
        System.out.println("Delivery Date: " + order.getDeliveryDate());
        System.out.println("------------------------");

    }

    public static void displayProducts(Order order) {
        List<Product> products = order.getProducts();
        System.out.println("Order Products:");
        for (Product product : products) {
            System.out.println("------------------------");
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Category: " + product.getCategory());
            System.out.println("Price: " + product.getPrice());
            System.out.println("------------------------");
        }
    }

    public static void displayCustomer(Customer customer) {
        System.out.println("------------------------");
        System.out.println("Customer:");
        System.out.println("ID: " + customer.getId());
        System.out.println("Name: " + customer.getName());
        System.out.println("Tier: " + customer.getTier());
        System.out.println("------------------------");

    }
}
