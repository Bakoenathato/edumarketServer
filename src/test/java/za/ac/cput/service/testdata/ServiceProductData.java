package za.ac.cput.service.testdata;

import za.ac.cput.domain.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ServiceProductData {

    private static User user = new User.Builder()
                                    .setFirstName("Leonard")
                                    .setLastName("Langa")
                                    .setEmail("12345@gmail.com")
                                    .setPassword("12345")
                                    .setPhone("+27 722262597")
                                    .setResidence("NMJ")
                                    .setRole(Role.ADMIN)
                                    .build();


    public static ServiceProduct getBuiltServiceProduct1() {

        byte[] serviceImage1;
        try {
            serviceImage1 = Files.readAllBytes(Paths.get("src/main/resources/services/tutoring.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  new ServiceProduct.Builder()
                .setServiceName("Tutoring")
                .setServiceDescription("This is a Description")
                .setServicePrice(1500)
                .setServiceCategory(ServiceCategory.TUTORING)
                .setServiceImage(serviceImage1)
                .setUser(user)
                .build();
    }

    public static ServiceProduct getBuiltServiceProduct2() {

        byte[] serviceImage2;
        try {
            serviceImage2 = Files.readAllBytes(Paths.get("src/main/resources/services/hairstyling.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  new ServiceProduct.Builder()
                .setServiceName("Women hairstyling")
                .setServiceDescription("This is a Description")
                .setServicePrice(500)
                .setServiceCategory(ServiceCategory.WOMENHAIRSTYLING)
                .setServiceImage(serviceImage2)
                .setUser(user)
                .build();
    }

    public static ServiceProduct getBuiltServiceProduct3() {

        byte[] serviceImage3;
        try {
            serviceImage3 = Files.readAllBytes(Paths.get("src/main/resources/services/tutoring.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  new ServiceProduct.Builder()
                .setServiceName("MENHAIRCUTS")
                .setServiceDescription("This is a Description")
                .setServicePrice(40)
                .setServiceCategory(ServiceCategory.MENHAIRCUTS)
                .setServiceImage(serviceImage3)
                .setUser(user)
                .build();
    }

    public static ServiceProduct getBuiltServiceProduct4() {

        byte[] serviceImage4;
        try {
            serviceImage4 = Files.readAllBytes(Paths.get("src/main/resources/services/hairstyling.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  new ServiceProduct.Builder()
                .setServiceName("Other Staff")
                .setServiceDescription("This is a Description")
                .setServicePrice(5000)
                .setServiceCategory(ServiceCategory.OTHER)
                .setServiceImage(serviceImage4)
                .setUser(user)
                .build();
    }
}
