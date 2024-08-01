package Abstract;

import java.util.Random;

public class Category {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public Category(String name) {
        Random random = new Random();
        this.id = random.nextLong();
        this.name = name;
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
}
