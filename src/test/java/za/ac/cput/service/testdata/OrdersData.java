package za.ac.cput.service.testdata;

import za.ac.cput.domain.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class OrdersData {
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
                .setId(2L)
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
                .setCartId(3L)
                .setUser(user)
                .setProduct(product())
                .setQuantity(1)
                .build();
    }

    public static Orders order() {
        return new Orders.Builder()
                .setUser(user)
                .setProductCart(productCart())
                .setOrderDate(LocalDate.now())
                .setOrderTotal(1500)
                .build();
    }
}
