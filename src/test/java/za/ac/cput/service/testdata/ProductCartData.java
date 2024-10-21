package za.ac.cput.service.testdata;

import za.ac.cput.domain.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProductCartData {
    private static User user = new User.Builder()
            .setUserId(1L)
            .setFirstName("Leonard")
            .setLastName("Langa")
            .setEmail("12345@gmail.com")
            .setPassword("12345")
            .setPhone("+27 722262597")
            .setResidence("NMJ")
            .setRole(Role.USER)
            .build();

    public static Product product() {

        byte[] lenovoImage1;
        try {
            lenovoImage1 = Files.readAllBytes(Paths.get("src/main/resources/images/lenovo.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  new Product.Builder()
                .setProductName("iPhone 12")
                .setProductPrice(1500)
                .setProductDescription("")
                .setCategory(Categories.ELECTRONICS)
                .setProductCondition(Condition.NEW)
                .setProductDescription("This is the product description")
                .setQuantity(2)
                .setProductImage(lenovoImage1)
                .setUser(user)
                .build();
    }

    public static ProductCart productCart() {
        return new ProductCart.Builder()
                .setUser(user)
                .setProduct(product())
                .setQuantity(1)
                .build();
    }

    /*------------------second Cart-----------------------------------*/

    public static Product secondProduct() {

        byte[] electronicsImage2;
        try {
            electronicsImage2 = Files.readAllBytes(Paths.get("src/main/resources/images/electronics.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  new Product.Builder()
                .setProductName("ASUS ROG 2000")
                .setProductPrice(15000)
                .setProductDescription("")
                .setCategory(Categories.APPLIANCE)
                .setProductCondition(Condition.GOOD)
                .setProductDescription("This is the product description")
                .setQuantity(5)
                .setProductImage(electronicsImage2)
                .setUser(user)
                .build();
    }

    public static ProductCart secondProductCart() {
        return new ProductCart.Builder()
                .setUser(user)
                .setProduct(secondProduct())
                .setQuantity(2)
                .build();
    }

}
