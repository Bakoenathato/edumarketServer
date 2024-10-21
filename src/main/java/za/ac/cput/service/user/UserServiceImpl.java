package za.ac.cput.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.User;
import za.ac.cput.dto.LoginDTO;
import za.ac.cput.dto.LoginResponse;
import za.ac.cput.repository.ProductRepository;
import za.ac.cput.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public User create(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("There is already a user with this email in the system please try to login");
        }
        return userRepository.save(user);
    }

    @Override
    public User read(Long userId){
        return userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException("User not found"));
    }

    @Transactional
    @Override
    public User update(User user) {
        if (userRepository.existsById(user.getUserId())) {
            return userRepository.save(user);
        }
        else {
            throw new IllegalArgumentException("User not found with id:" + user.getUserId());
        }
    }

    @Override
    public boolean delete(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        else {
            throw new IllegalArgumentException("User not found");
        }
    }

    @Override
    public List<Product> getProductsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return productRepository.findProductsByUser(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }



    public LoginResponse loginUser(LoginDTO loginDTO) {
        User user1 = userRepository.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String storedPassword = user1.getPassword();
            if (password.equals(storedPassword)) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), storedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Password Not Match", false);
            }
        } else {
            return new LoginResponse("Email not exists", false);
        }
    }
}
