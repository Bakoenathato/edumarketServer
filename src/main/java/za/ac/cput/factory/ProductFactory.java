package za.ac.cput.factory;

import za.ac.cput.domain.Categories;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

public class ProductFactory {
    public static Product createProduct(String productName, String productDescription, double productPrice, byte[] productImage, Categories categories) {
        if (Helper.isNullOrEmpty(productName) || Helper.isNullOrEmpty(productDescription) || productPrice < 0 || productImage == null || categories == null) {
            return null;
        }

        return new Product.Builder()
                .setProductName(productName)
                .setProductDescription(productDescription)
                .setProductPrice(productPrice)
                .setProductImage(productImage)
                .setCategory(categories)
                .build();
    }
}
