package za.ac.cput.service.serviceproduct;

import za.ac.cput.domain.Product;
import za.ac.cput.domain.ServiceProduct;
import za.ac.cput.service.IService;

import java.util.List;

public interface IServiceProduct extends IService<ServiceProduct, Long> {
    List<ServiceProduct> getAll();
}
