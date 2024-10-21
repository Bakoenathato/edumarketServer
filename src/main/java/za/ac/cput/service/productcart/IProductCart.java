package za.ac.cput.service.productcart;

import za.ac.cput.domain.ProductCart;
import za.ac.cput.service.IService;

import java.util.List;

public interface IProductCart extends IService<ProductCart, Long> {
    List<ProductCart> getAll();
}
