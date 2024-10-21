package za.ac.cput.service.user;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.User;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    private static User user1;
    private static User user2;

    @BeforeAll
    static void setUp() {
        user1 = new User.Builder()
                .setFirstName("Leonard")
                .setLastName("Langa")
                .setEmail("12345@gmail.com")
                .setPassword("12345")
                .setPhone("+27 722262597")
                .setResidence("NMJ")
                .setRole(Role.ADMIN)
                .build();

        user2 = new User.Builder()
                .setFirstName("Miles")
                .setLastName("Herbert")
                .setEmail("my12345@gmail.com")
                .setPassword("12345")
                .setPhone("+27 722262597")
                .setResidence("NMJ")
                .setRole(Role.USER)
                .build();
    }

    @Test
    void create() {
        User userCreated1 = userServiceImpl.create(user1);
        assertNotNull(userCreated1);
//        User userCreated2 = userServiceImpl.create(user2);
//        assertNotNull(userCreated2);
        System.out.println(userCreated1);
//        System.out.println(userCreated2);
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
    void findByEmail() {
    }

    @Test
    @Disabled
    void findByFirstName() {
    }
}