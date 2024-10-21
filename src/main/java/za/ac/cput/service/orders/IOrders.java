package za.ac.cput.service.orders;

import za.ac.cput.domain.Orders;
import za.ac.cput.service.IService;

import java.util.List;

public interface IOrders extends IService<Orders, Long> {
    List<Orders> getAll();
}
