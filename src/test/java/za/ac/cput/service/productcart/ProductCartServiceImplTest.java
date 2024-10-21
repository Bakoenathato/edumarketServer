package za.ac.cput.service.productcart;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ProductCart;
import za.ac.cput.service.testdata.ProductCartData;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductCartServiceImplTest {

    @Autowired
    private ProductCartServiceImpl productCartServiceImpl;

    private static ProductCart productCart;
    private static ProductCart productCart2;

    @BeforeAll
    static void setUp() {
        productCart = ProductCartData.productCart();
        System.out.println(productCart);
        productCart2 = ProductCartData.secondProductCart();
    }

    @Test
    void create() {
//        ProductCart created = productCartService.create(productCart);
//        assertNotNull(created);
//        System.out.println(created);
          ProductCart created = productCartServiceImpl.create(productCart);
          assertNotNull(created);
          System.out.println(created);
    }

    @Test
    @Disabled
    void read() {
    }

    @Test
    @Disabled
    void update() {
    }

    @Test
    @Disabled
    void delete() {
    }

    @Test
    @Disabled
    void getAll() {
    }

    @Test
    @Disabled
    void getCartItems() {
    }

    @Test
    @Disabled
    void removeFromCart() {
    }
}