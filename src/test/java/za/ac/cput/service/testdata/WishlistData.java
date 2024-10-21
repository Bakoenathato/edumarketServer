package za.ac.cput.service.testdata;

import za.ac.cput.domain.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WishlistData {

    private static User user = new User.Builder()
//            .setUserId(1L)
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
        return new Product.Builder()
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

    public static Wishlist wishlist() {
        return new Wishlist.Builder()
                .setUser(user)
                .setProduct(getBuiltProduct1())
                .build();

    }

}
