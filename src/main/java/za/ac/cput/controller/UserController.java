package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.dto.LoginDTO;
import za.ac.cput.dto.LoginResponse;
import za.ac.cput.service.user.UserServiceImpl;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody User user) {
        try {
            User createdUser = userServiceImpl.create(user);
            return ResponseEntity.ok(createdUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/read/{userId}")
    public User read(@PathVariable long userId){
        return userServiceImpl.read(userId);
    }

    @GetMapping("/getall")
    public List<User> getall(){
        return userServiceImpl.getAll();
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = userServiceImpl.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

}
