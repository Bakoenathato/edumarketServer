package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.User;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findProductByProductName(String productName);

    List<Product> findProductsByUser(User user);
//
//    List<Product> findProductsByPriceBetween(Double minPrice, Double maxPrice);

//    List<Product> findProductByCategory(Category category);
}

