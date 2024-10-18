package za.ac.cput.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
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

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
