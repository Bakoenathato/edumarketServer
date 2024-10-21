package za.ac.cput.service.productcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCart;
import za.ac.cput.domain.User;
import za.ac.cput.repository.ProductCartRepository;
import za.ac.cput.repository.ProductRepository;
import za.ac.cput.repository.UserRepository;

import java.util.List;

@Service
public class ProductCartServiceImpl implements IProductCart{

    private UserRepository userRepository;
    private ProductRepository productRepository;
    private ProductCartRepository productCartRepository;

    @Autowired
    ProductCartServiceImpl(UserRepository userRepository, ProductRepository productRepository, ProductCartRepository productCartRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.productCartRepository = productCartRepository;
    }

    @Override
    public ProductCart create(ProductCart productCart) {
        User user = productCart.getUser();
        Product product = productCart.getProduct();
        userRepository.save(user);
        productRepository.save(product);
        return productCartRepository.save(productCart);
    }

    @Override
    public ProductCart read(Long productCartId) {
        return productCartRepository.findById(productCartId).orElseThrow(() -> new IllegalArgumentException("ProductCart with id: " + productCartId + " not found"));
    }
    @Override
    public ProductCart update(ProductCart productCart) {
        User user = productCart.getUser();
        Product product = productCart.getProduct();
        userRepository.save(user);
        productRepository.save(product);
        return productCartRepository.save(productCart);
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public List<ProductCart> getAll() {
        return productCartRepository.findAll();
    }

    public List<ProductCart> getCartItems(User user) {
        return productCartRepository.findByUser(user);
    }

    public void removeFromCart(Long productCartId) {
        productCartRepository.deleteById(productCartId);
    }
}
