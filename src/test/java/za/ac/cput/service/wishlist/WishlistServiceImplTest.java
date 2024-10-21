package za.ac.cput.service.wishlist;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.service.testdata.WishlistData;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WishlistServiceImplTest {

    @Autowired
    private WishlistServiceImpl wishlistService;

    private static Wishlist wishlist;

    @BeforeAll
    static void setUp() {
        wishlist = WishlistData.wishlist();

    }

    @Test
    void create() {
        Wishlist wishlist1 = wishlistService.create(wishlist);
        assertNotNull(wishlist1);
        System.out.println(wishlist1);
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
    void removeFromCart() {
    }
}