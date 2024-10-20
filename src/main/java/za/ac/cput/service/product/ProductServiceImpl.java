package za.ac.cput.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.User;
import za.ac.cput.repository.ProductRepository;
import za.ac.cput.repository.UserRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    private final ProductRepository productRepository;

    private UserRepository userRepository;

    @Autowired
    public ProductServiceImpl(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        if (productRepository.findProductByProductName(product.getProductName()) != null) {
            throw new IllegalArgumentException("There is already a product with this name please try another one");
        }
        User user = product.getUser();
        userRepository.save(user);
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Product createProductForUser(Product product, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        product = new Product.Builder()
                .setProductName(product.getProductName())
                .setProductDescription(product.getProductDescription())
                .setProductPrice(product.getProductPrice())
                .setCategory(product.getCategory())
                .setProductCondition(product.getProductCondition())
                .setQuantity(product.getQuantity())
                .setUser(user)
                .setProductImage(product.getProductImage())
                .build();
        return productRepository.save(product);
    }

    @Override
    public Product read(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product with id: " + id + " not found"));
    }

    @Override
    public Product update(Product product) {
        if (productRepository.existsById(product.getId())) {
            return productRepository.save(product);
        } else {
            throw new IllegalArgumentException("Product with id: " + product.getId() + " not found");
        }
    }

    @Override
    public boolean delete(Long id) {
       if (productRepository.existsById(id)) {
           productRepository.deleteById(id);
           return true;
       } else {
           throw new IllegalArgumentException("Product with id: " + id + " not found");
       }
    }

    public Product findProductByProductName(String productName) {
        return productRepository.findProductByProductName(productName);
    }



    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
//
//    // Assign or change the user associated with a product
//    public Product assignUserToProduct(Long productId, Long userId) {
//        Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
//
//        product.setUser(user);
//        return productRepository.save(product);
//    }
//
//    // Remove user association from product
//    public Product removeUserFromProduct(Long productId) {
//        Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
//
//        product.setUser(null); // Remove association
//        return productRepository.save(product);
//    }
//
//    // Find all products (with or without users)
//    public List<Product> getAllProducts() {
//        return productRepository.findAll();
//    }
//
//    // Find products without a user
//    public List<Product> getProductsWithoutUser() {
//        return productRepository.findProductsWithoutUser();
//    }


}
