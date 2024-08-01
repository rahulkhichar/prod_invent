package interfaces;


import Abstract.Product;

import java.util.List;

public interface InventoryService {
    void addProduct(Product product);
    void updateProductQuantity(String productName, int quantity);
    List<Product> getAllProducts();
    List<Product> getProductsByName(String name);
    List<Product> getProductsByCategory(String category);
}
