package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ServiceProduct;

@Repository
public interface ServiceProductRepository extends JpaRepository<ServiceProduct, Long> {

}
