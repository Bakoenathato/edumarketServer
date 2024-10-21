package za.ac.cput.service.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.ProductCart;
import za.ac.cput.domain.User;
import za.ac.cput.repository.OrdersRepository;
import za.ac.cput.repository.ProductCartRepository;
import za.ac.cput.repository.ServiceProductRepository;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.service.productcart.ProductCartServiceImpl;

import java.util.List;

@Service
public class OrdersServiceImpl implements IOrders{

    private UserRepository userRepository;
    private ProductCartRepository productCartRepository;
    private OrdersRepository ordersRepository;

    @Autowired
    OrdersServiceImpl(UserRepository userRepository, ProductCartRepository productCartRepository, OrdersRepository ordersRepository) {
        this.userRepository = userRepository;
        this.productCartRepository = productCartRepository;
        this.ordersRepository = ordersRepository;
    }

    @Override
    public Orders create(Orders orders) {
        User user = orders.getUser();
        ProductCart productCart = orders.getProductCart();
        userRepository.save(user);
        productCartRepository.save(productCart);
        return ordersRepository.save(orders);
    }

    @Override
    public Orders read(Long aLong) {
        return null;
    }

    @Override
    public Orders update(Orders orders) {
        User user = orders.getUser();
        ProductCart productCart = orders.getProductCart();
        userRepository.save(user);
        productCartRepository.save(productCart);
        return ordersRepository.save(orders);
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public List<Orders> getAll() {
        return ordersRepository.findAll();
    }

}
