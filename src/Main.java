import domain.initializer.DataInitializer;
import domain.models.*;

import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {

    public static void main(String[] args) {
        Order order = DataInitializer.initializeOrder();

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 4) {
            System.out.println("----- Menu -----");
            System.out.println("1. Mostrar detalles del pedido");
            System.out.println("2. Mostrar productos del pedido");
            System.out.println("3. Mostrar detalles del cliente");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    displayOrderDetails(order);
                    break;
                case 2:
                    displayOrderProducts(order);
                    break;
                case 3:
                    displayCustomerDetails(order.customer);
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }

        scanner.close();
    }

    public static void displayOrderDetails(Order order) {
        System.out.println("Detalles del pedido:");
        System.out.println("ID: " + order.id);
        System.out.println("Estado: " + order.status);
        System.out.println("Fecha de pedido: " + order.orderDate);
        System.out.println("Fecha de entrega: " + order.deliveryDate);
    }

    public static void displayOrderProducts(Order order) {
        List<Product> products = order.products;
        System.out.println("Productos del pedido:");
        for (Product product : products) {
            System.out.println("ID: " + product.id);
            System.out.println("Nombre: " + product.name);
            System.out.println("Categoría: " + product.category);
            System.out.println("Precio: " + product.price);
            System.out.println("------------------------");
        }
    }

    public static void displayCustomerDetails(Customer customer) {
        System.out.println("Detalles del cliente:");
        System.out.println("ID: " + customer.id);
        System.out.println("Nombre: " + customer.name);
        System.out.println("Nivel: " + customer.tier);
    }
}
