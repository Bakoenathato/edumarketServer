package za.ac.cput.service.serviceproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ServiceProduct;
import za.ac.cput.domain.User;
import za.ac.cput.repository.ServiceProductRepository;
import za.ac.cput.repository.UserRepository;

import java.util.List;

@Service
public class ServiceProductServiceImpl implements IServiceProduct{

    private UserRepository userRepository;
    private ServiceProductRepository serviceProductRepository;


    @Autowired
    public ServiceProductServiceImpl(UserRepository userRepository, ServiceProductRepository serviceProductRepository) {
        this.userRepository = userRepository;
        this.serviceProductRepository = serviceProductRepository;
    }
    @Override
    public ServiceProduct create(ServiceProduct serviceProduct) {
        User user = serviceProduct.getUser();
        userRepository.save(user);
        return serviceProductRepository.save(serviceProduct);
    }

    @Override
    public ServiceProduct read(Long serviceProductId) {
        return serviceProductRepository.findById(serviceProductId).orElseThrow(() -> new IllegalArgumentException("ServiceProductId with id: " + serviceProductId + " not found"));
    }

    @Override
    public ServiceProduct update(ServiceProduct serviceProduct) {
        return null;
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public List<ServiceProduct> getAll() {
        return serviceProductRepository.findAll();
    }
}
