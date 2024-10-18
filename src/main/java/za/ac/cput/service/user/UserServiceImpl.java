package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User read(Long userId){
        return userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException("User not found"));
    }

    @Override
    public User update(User user) {
        if (userRepository.existsById(user.getUserId())) {
            return userRepository.save(user);
        }
        else {
            throw new IllegalArgumentException("User not found");
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
    public List<User> getAll() {
        return userRepository.findAll();
    }

    
}
