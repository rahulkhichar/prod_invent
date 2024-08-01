package services;



import Abstract.Product;
import interfaces.InventoryService;
import interfaces.NotificationService;

import java.util.ArrayList;
import java.util.List;

public class InventoryServiceImpl implements InventoryService {
    private List<Product> products;
    private int lowStockThreshold = 2;
    private NotificationService notificationService;


    public InventoryServiceImpl() {
        this.products = new ArrayList<>();
    }

    public void printProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProductQuantity(String productName, int quantity) {
        products.stream()
                .filter(p -> p.getName().equals(productName))
                .findFirst()
                .ifPresent(product -> {
                    product.setQuantity(product.getQuantity() + quantity);
                    if (product.getQuantity() < lowStockThreshold) {
                        notificationService = new NotificationImpl();
                        notificationService.sendNotification("Low stock notification: " + product.getName());
                    }
                });
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public List<Product> getProductsByName(String name) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    public List<Product> getProductsByCategory(String category) {
        return products.stream()
                .filter(p -> p.getCategory().getName().equalsIgnoreCase(category))
                .toList();
    }
}