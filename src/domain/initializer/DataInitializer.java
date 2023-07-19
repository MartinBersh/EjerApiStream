package domain.initializer;
import domain.enumm.ClientTier;
import domain.enumm.ProductCategory;
import domain.models.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataInitializer {

    public static Order initializeOrder() {

        Order order = new Order();
        order.setId(1L);
        order.setStatus("Waiting");;
        order.setOrderDate(LocalDate.now());
        order.setDeliveryDate(LocalDate.now().plusDays(7)) ;
        order.setProducts(initializeProducts());
        order.setCustomer(initializeCustomer()) ;

        return order;
    }

    public static List<Product> initializeProducts() {
        List<Product> products = new ArrayList<>();

        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("La biblia");
        product1.setCategory(ProductCategory.LIBROS);
        product1.setPrice(50000.5);
        products.add(product1);

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Don quijote");
        product2.setCategory(ProductCategory.LIBROS);
        product2.setPrice(65000.4);
        products.add(product2);

        Product product3 = new Product();
        product3.setId(3L);
        product3.setName("Tetero");
        product3.setCategory(ProductCategory.BEBE);
        product3.setPrice(100000.0);
        products.add(product3);

        return products;
    }

    public static List<Customer> initializeCustomer() {

        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setName("Martin Villegas");
        customer1.setTier(ClientTier.TYPE1);


        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setName("Felpe Rojas");
        customer2.setTier(ClientTier.TYPE2);


        return customers;
    }
}
