package services;



import Abstract.Category;
import interfaces.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {

    List<Category> categories = new ArrayList<>();

    @Override
    public Category addOrFindCategory(String name) {

        Optional<Category> existingCategory = categories.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst();

        return existingCategory.orElseGet(() -> {
            Category newCategory = new Category(name);
            categories.add(newCategory);
            return newCategory;
        });
    }
}
