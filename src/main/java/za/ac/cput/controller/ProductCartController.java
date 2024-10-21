package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.ProductCart;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.service.productcart.ProductCartServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/productcart")
public class ProductCartController {

    @Autowired
    private ProductCartServiceImpl productCartServiceImpl;


    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductCart productCart) {
        try {
            ProductCart createdProductCart = productCartServiceImpl.create(productCart);
            return ResponseEntity.ok(createdProductCart);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getall")
    public List<ProductCart> getall(){
        return productCartServiceImpl.getAll();
    }

    @GetMapping("/read/{productCartId}")
    public ProductCart read(@PathVariable long productCartId){
        return productCartServiceImpl.read(productCartId);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ProductCart>> getCartItems(@RequestParam Long userId) {
        // Fetch user by ID
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            // Return a 404 status if the user is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Fetch cart items for the user
        User user = userOptional.get();
        List<ProductCart> cartItems = productCartServiceImpl.getCartItems(user);

        // Return the cart items
        return ResponseEntity.ok(cartItems);
    }

    @DeleteMapping("/delete/{productCartId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long productCartId) {
        try {
            productCartServiceImpl.removeFromCart(productCartId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update")
    public ProductCart update(@RequestBody ProductCart productCartId){
        return productCartServiceImpl.update(productCartId);
    }

}
