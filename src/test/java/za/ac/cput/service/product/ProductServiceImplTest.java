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
    private static Product product3;
    private static Product product4;
    private static Product product5;
    private static Product product6;


    @BeforeAll
    static void setUp() {
        product1 = ProductData.getBuiltProduct1();
        product2 = ProductData.getBuiltProduct2();
        product3 = ProductData.getBuiltProduct3();
        product4 = ProductData.getBuiltProduct4();
        product5 = ProductData.getBuiltProduct5();
        product6 = ProductData.getBuiltProduct6();
    }


    @Test
    void create() {
//        Product productCreated1 = productServiceImpl.create(product1);
        Product productCreated2 = productServiceImpl.create(product2);
        Product productCreated3 = productServiceImpl.create(product3);
        Product productCreated4 = productServiceImpl.create(product4);
        Product productCreated5 = productServiceImpl.create(product5);
        Product productCreated6 = productServiceImpl.create(product6);
//        assertNotNull(productCreated1);
        assertNotNull(productCreated2);
        assertNotNull(productCreated3);
        assertNotNull(productCreated4);
        assertNotNull(productCreated5);
        assertNotNull(productCreated6);
//        System.out.println(productCreated1);
        System.out.println(productCreated2);
        System.out.println(productCreated3);
        System.out.println(productCreated4);
        System.out.println(productCreated5);
        System.out.println(productCreated6);
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