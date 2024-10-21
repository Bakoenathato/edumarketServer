package za.ac.cput.service.orders;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Orders;
import za.ac.cput.service.testdata.OrdersData;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrdersServiceImplTest {

    @Autowired
    private OrdersServiceImpl ordersService;

    private static Orders order1;
//    private Orders order2;

    @BeforeAll
    static void setUp() {
        order1 = OrdersData.order();
        System.out.println(order1);
    }

    @Test
    void create() {
        Orders order2 = ordersService.create(order1);
        assertNotNull(order2);
        System.out.println(order2);
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