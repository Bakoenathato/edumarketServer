package za.ac.cput.service.product;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Categories;
import za.ac.cput.domain.Condition;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.User;
import za.ac.cput.service.testdata.ProductData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    private static Product product1;
    private static Product product2;


    @BeforeAll
    static void setUp() {
        product1 = ProductData.getBuiltProduct1();
        product2 = ProductData.getBuiltProduct4();
    }


    @Test
    void create() {
        Product productcreated1 = productServiceImpl.create(product1);
        Product productcreated2 = productServiceImpl.create(product2);
        assertNotNull(productcreated1);
        assertNotNull(productcreated2);
        System.out.println(productcreated1);
        System.out.println(productcreated2);
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
    void findProductByProductName() {
    }

    @Test
    @Disabled
    void getAll() {
    }
}