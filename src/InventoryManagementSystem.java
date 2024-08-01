

import Abstract.Category;
import Abstract.Product;
import interfaces.CategoryService;
import interfaces.InventoryService;
import services.CategoryServiceImpl;
import services.InventoryServiceImpl;

import java.util.List;
import java.util.Scanner;

public class InventoryManagementSystem {

    public static void main(String[] args) {

        InventoryService inventory = new InventoryServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();
        Scanner scanner = new Scanner(System.in);


        int choice;
        do {
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Quantity");
            System.out.println("3. List All Products");
            System.out.println("4. Search Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.next();
                    System.out.print("Enter product category: ");
                    String productCategory = scanner.next();
                    System.out.print("Enter product price: ");
                    double productPrice = scanner.nextDouble();
                    System.out.print("Enter initial quantity: ");
                    int productQuantity = scanner.nextInt();
                    Category category=categoryService.addOrFindCategory(productCategory);
                    Product newProduct = new Product(productName, category, productPrice, productQuantity);
                    inventory.addProduct(newProduct);
                    break;
                case 2:
                    System.out.print("Enter product name to update: ");
                    String updateProductName = scanner.next();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    inventory.updateProductQuantity(updateProductName, newQuantity);
                    break;
                case 3:
                    List<Product> allProducts = inventory.getAllProducts();
                    for (Product product : allProducts) {
                        System.out.println(product);
                    }
                    break;
                case 4:
                    System.out.println("1. Search by name");
                    System.out.println("2. Search by category");
                    int searchChoice = scanner.nextInt();
                    if (searchChoice == 1) {
                        System.out.print("Enter product name: ");
                        String searchName = scanner.next();
                        List<Product> foundProducts = inventory.getProductsByName(searchName);
//                        inventory.printProducts(foundProducts);
                    } else if (searchChoice == 2) {
                        System.out.print("Enter product category: ");
                        String searchCategory = scanner.next();
                        List<Product> foundProducts = inventory.getProductsByCategory(searchCategory);
                    } else {
                        System.out.println("Invalid search choice");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }
}
