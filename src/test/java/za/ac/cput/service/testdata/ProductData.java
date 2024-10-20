package za.ac.cput.service.testdata;

import za.ac.cput.domain.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProductData {


    private static User user = new User.Builder()
            .setUserId(1L)
            .setFirstName("Leonard")
            .setLastName("Langa")
            .setEmail("12345@gmail.com")
            .setPassword("12345")
            .setPhone("+27 722262597")
            .setResidence("NMJ")
            .setRole(Role.ADMIN)
            .build();

    public static Product getBuiltProduct1() {

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

    public static Product getBuiltProduct2() {

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

    public static Product getBuiltProduct3() {

        byte[] lenovoImage3;
        try {
            lenovoImage3 = Files.readAllBytes(Paths.get("src/main/resources/images/electronics.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  new Product.Builder()
                .setProductName("Idea Pad")
                .setProductPrice(2500)
                .setProductDescription("")
                .setCategory(Categories.ELECTRONICS)
                .setProductCondition(Condition.LIKENEW)
                .setQuantity(5)
                .setProductImage(lenovoImage3)
                .setUser(user)
                .build();
    }

    public static Product getBuiltProduct4() {

        byte[] lenovoImage4;
        try {
            lenovoImage4 = Files.readAllBytes(Paths.get("src/main/resources/images/lenovo.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  new Product.Builder()
                .setProductName("Samsung Pad 2")
                .setProductPrice(20000)
                .setProductDescription("")
                .setCategory(Categories.ELECTRONICS)
                .setProductCondition(Condition.LIKENEW)
                .setQuantity(2)
                .setProductImage(lenovoImage4)
                .setUser(user)
                .build();
    }

    public static Product getBuiltProduct5() {

        byte[] lenovoImage4;
        try {
            lenovoImage4 = Files.readAllBytes(Paths.get("src/main/resources/images/lenovo.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  new Product.Builder()
                .setProductName("Lenovo Note 3")
                .setProductPrice(3000)
                .setProductDescription("")
                .setCategory(Categories.ELECTRONICS)
                .setProductCondition(Condition.LIKENEW)
                .setQuantity(6)
                .setProductImage(lenovoImage4)
                .setUser(user)
                .build();
    }

    public static Product getBuiltProduct6() {

        byte[] lenovoImage4;
        try {
            lenovoImage4 = Files.readAllBytes(Paths.get("src/main/resources/images/lenovo.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  new Product.Builder()
                .setProductName("ASUS SPACE ROUGE")
                .setProductPrice(7000)
                .setProductDescription("")
                .setCategory(Categories.ELECTRONICS)
                .setProductCondition(Condition.LIKENEW)
                .setQuantity(1)
                .setProductImage(lenovoImage4)
                .setUser(user)
                .build();
    }


}
