package Abstract;

import java.util.Random;

public class Product {
    private Long id;
    private String name;

    private double price;
    private int quantity;
    private Category category;

    public Product(String name, Category category, double price, int quantity) {
        Random random = new Random();
        this.name = name;
        this.price = price;
        this.id = random.nextLong();
        this.quantity = quantity;
        this.category = category;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
