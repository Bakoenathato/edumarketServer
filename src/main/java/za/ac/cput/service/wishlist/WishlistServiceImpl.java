package za.ac.cput.service.wishlist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCart;
import za.ac.cput.domain.User;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.repository.ProductRepository;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.repository.WishlistRepository;

import java.util.List;

@Service
public class WishlistServiceImpl implements IWishlistService{

    private UserRepository userRepository;
    private ProductRepository productRepository;
    private WishlistRepository wishlistRepository;

    @Autowired
    public WishlistServiceImpl(UserRepository userRepository, ProductRepository productRepository, WishlistRepository wishlistRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.wishlistRepository = wishlistRepository;
    }

    @Override
    public Wishlist create(Wishlist wishlist) {
        User user = wishlist.getUser();
        Product product = wishlist.getProduct();
        userRepository.save(user);
        productRepository.save(product);
        return wishlistRepository.save(wishlist);
    }

    @Override
    public Wishlist read(Long wishlistId) {
        return wishlistRepository.findById(wishlistId).orElseThrow(()->new IllegalArgumentException("Wishlist not found"));
    }

    @Override
    public Wishlist update(Wishlist wishlist) {
        return null;
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public List<Wishlist> getAll() {
        return wishlistRepository.findAll();
    }

    public void removeFromCart(Long wishlistId) {
        wishlistRepository.deleteById(wishlistId);
    }

    public List<Wishlist> getWishlistItems(User user) {
        return wishlistRepository.findByUser(user);
    }
}
