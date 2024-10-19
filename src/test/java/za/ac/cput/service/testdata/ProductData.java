package za.ac.cput.service.testdata;

import za.ac.cput.domain.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProductData {

    private static User user = new User.Builder()
                            .setFirstName("Leonard")
                            .setLastName("Langa")
                            .setEmail("12345@gmail.com")
                            .setPassword("12345")
                            .setPhone("+27 722262597")
                            .setResidence("NMJ")
                            .setRole(Role.ADMIN)
                            .setProducts(null)
                            .build();

    public static Product getBuiltProduct1() {

        byte[] lenovoImage1;
        try {
            lenovoImage1 = Files.readAllBytes(Paths.get("src/main/resources/images/sonic.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  new Product.Builder()
                    .setProductName("Lenovo Idea Pad")
                    .setProductPrice(1500)
                    .setProductDescription("")
                    .setCategory(Categories.ELECTRONICS)
                    .setCondition(Condition.LIKENEW)
                    .setQuantity(2)
                    .setProductImage(lenovoImage1)
                    .setUser(user)
                    .build();
    }

    public static Product getBuiltProduct2() {

        byte[] lenovoImage2;
        try {
            lenovoImage2 = Files.readAllBytes(Paths.get("src/main/resources/images/sonic.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  new Product.Builder()
                .setProductName("Lenovo Idea Pad")
                .setProductPrice(1500)
                .setProductDescription("")
                .setCategory(Categories.ELECTRONICS)
                .setCondition(Condition.LIKENEW)
                .setQuantity(2)
                .setProductImage(null)
                .setUser(user)
                .build();
    }

    public static Product getBuiltProduct3() {

        byte[] lenovoImage3;
        try {
            lenovoImage3 = Files.readAllBytes(Paths.get("src/main/resources/images/sonic.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  new Product.Builder()
                .setProductName("Lenovo Idea Pad")
                .setProductPrice(1500)
                .setProductDescription("")
                .setCategory(Categories.ELECTRONICS)
                .setCondition(Condition.LIKENEW)
                .setQuantity(2)
                .setProductImage(null)
                .setUser(user)
                .build();
    }

    public static Product getBuiltProduct4() {

        byte[] lenovoImage4;
        try {
            lenovoImage4 = Files.readAllBytes(Paths.get("src/main/resources/images/sonic.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  new Product.Builder()
                .setProductName("ASUS ROG 2000")
                .setProductPrice(15000)
                .setProductDescription("")
                .setCategory(Categories.APPLIANCE)
                .setCondition(Condition.NEW)
                .setQuantity(2)
                .setProductImage(lenovoImage4)
                .setUser(user)
                .build();
    }
}
