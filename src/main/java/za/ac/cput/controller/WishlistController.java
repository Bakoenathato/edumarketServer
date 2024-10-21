package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCart;
import za.ac.cput.domain.User;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.repository.ProductRepository;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.repository.WishlistRepository;
import za.ac.cput.service.wishlist.WishlistServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    private WishlistServiceImpl wishlistServiceImpl;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Wishlist wishlist) {
        try {
            Wishlist createdWishlist = wishlistServiceImpl.create(wishlist);
            return ResponseEntity.ok(createdWishlist);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{wishlistId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long wishlistId) {
        try {
            wishlistServiceImpl.removeFromCart(wishlistId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getall")
    public List<Wishlist> getall(){
        return wishlistServiceImpl.getAll();
    }

    @GetMapping("/read/{wishlistId}")
    public Wishlist read(@PathVariable long wishlistId){
        return wishlistServiceImpl.read(wishlistId);
    }

    @GetMapping("/wishlistitems")
    public ResponseEntity<List<Wishlist>> getWishlistItems(@RequestParam Long userId) {
        // Fetch user by ID
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            // Return a 404 status if the user is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Fetch cart items for the user
        User user = userOptional.get();
        List<Wishlist> cartItems = wishlistServiceImpl.getWishlistItems(user);

        // Return the cart items
        return ResponseEntity.ok(cartItems);
    }
}
