package za.ac.cput.service.user;

import za.ac.cput.domain.Product;
import za.ac.cput.domain.User;
import za.ac.cput.service.IService;

import java.util.List;

public interface IUserService extends IService<User, Long> {
    List<User> getAll();

    User findByEmail(String email);

    User findByFirstName(String firstName);

    List<Product> getProductsByUserId(Long userId);
}
