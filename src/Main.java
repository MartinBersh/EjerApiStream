import domain.enumm.ProductCategory;
import domain.initializer.DataInitializer;
import domain.models.*;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Product> products = DataInitializer.initializeProducts();


        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 4) {
            System.out.println("Menú");
            System.out.println("1. Productos filtrados por Libros y precio menor a 100.000");
            System.out.println("2. Productos filtrados por categoria: Bebé");
            System.out.println("3. Productos filtrados por categoria: Juguetes (10% descuento)");
            System.out.println("4. Filtrar el libro más barato del catálogo");
            System.out.println("5. Exit");
            System.out.print("Option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1: getFilteredProductsBooks(products);
                break;

                case 2: getFilteredProductsBaby(products);
                break;

                case 3: getFilteredProductsToys(products);
                break;

                case 4: getCheapestBook(products);
                break;

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

    private static List<Product> getFilteredProductsBooks(List<Product> products) {
        String category ="libros";
        List<Product> filteredProducts =  products.stream()
                .filter(e->e.getCategory().equals(ProductCategory.fromValue(category)))
                .filter(e->e.getPrice()>100)
                .toList();
        for (Product product : filteredProducts) {
            System.out.println(product);
        }

        return filteredProducts;

    }

    private static List<Product> getFilteredProductsBaby(List<Product> products){
        String category = "bebe";

        List<Product> filteredProducts = products.stream()
                .filter(e->e.getCategory().equals(ProductCategory.fromValue(category)))
                .toList();

        for (Product product : filteredProducts) {
            System.out.println(product);
        }

        return filteredProducts;
    }

    private static List<Product> getFilteredProductsToys(List<Product> products){
        String category = "juguetes";
        List<Product> filteredProducts = products.stream()
                .filter(e->e.getCategory().equals(ProductCategory.fromValue(category)))
                .map(e -> new Product(e.getId(), e.getName(), e.getCategory(), applyDiscount(e.getPrice())))
                .collect(Collectors.toList());

        for (Product product : filteredProducts) {
            System.out.println(product);
        }

        return filteredProducts;

    }

    private static double applyDiscount(double price){
        double discount = 0.1;
        return price - (price * discount);
    }

    private static List<Product> getCheapestBook(List<Product> products){
        String category = "libros";
        List<Product> filteredProducts = products.stream()
                .filter(e->e.getCategory().equals(ProductCategory.fromValue(category)))
                .min(Comparator.comparingDouble(Product::getPrice))
                .stream().toList();

        for (Product product : filteredProducts) {
            System.out.println(product);
        }

        return  filteredProducts;

    }

}
