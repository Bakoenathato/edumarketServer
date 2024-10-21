package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.ProductCart;
import za.ac.cput.domain.User;

import java.util.List;

@Repository
public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {
    List<ProductCart> findByProductId(Long productId);
    List<ProductCart> findByCartId(Long cartId);
    List<ProductCart> findByProductIdAndCartId(Long productId, Long cartId);
    List<ProductCart> findByCartIdAndProductId(Long cartId, Long productId);
    List<ProductCart> findByUser(User user);
}
