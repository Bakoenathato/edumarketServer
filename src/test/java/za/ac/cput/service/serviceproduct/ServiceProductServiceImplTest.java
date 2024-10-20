package za.ac.cput.service.serviceproduct;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ServiceProduct;
import za.ac.cput.service.testdata.ServiceProductData;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ServiceProductServiceImplTest {

    @Autowired
    private ServiceProductServiceImpl serviceProductServiceImpl;

    private static ServiceProduct serviceProduct1;
    private static ServiceProduct serviceProduct2;
    private static ServiceProduct serviceProduct3;
    private static ServiceProduct serviceProduct4;

    @BeforeAll
    static void setUp() {
        serviceProduct1 = ServiceProductData.getBuiltServiceProduct1();
        serviceProduct2 = ServiceProductData.getBuiltServiceProduct2();
        serviceProduct3 = ServiceProductData.getBuiltServiceProduct3();
        serviceProduct4 = ServiceProductData.getBuiltServiceProduct4();

    }

    @Test
    void create() {
        serviceProductServiceImpl.create(serviceProduct1);
        serviceProductServiceImpl.create(serviceProduct2);
        serviceProductServiceImpl.create(serviceProduct3);
        serviceProductServiceImpl.create(serviceProduct4);
        assertNotNull(serviceProduct1);
        assertNotNull(serviceProduct2);
        assertNotNull(serviceProduct3);
        assertNotNull(serviceProduct4);
        System.out.println(serviceProduct1);
        System.out.println(serviceProduct2);
        System.out.println(serviceProduct3);
        System.out.println(serviceProduct4);
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
}