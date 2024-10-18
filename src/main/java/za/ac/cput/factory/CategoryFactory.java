package za.ac.cput.factory;

import za.ac.cput.domain.Category;
import za.ac.cput.util.Helper;

public class CategoryFactory {
    public static Category getCategory(String categoryName) {
        if (Helper.isNullOrEmpty(categoryName)) {
            return null;
        }

        return new Category.Builder()
                .setCategoryName(categoryName)
                .build();
    }
}
