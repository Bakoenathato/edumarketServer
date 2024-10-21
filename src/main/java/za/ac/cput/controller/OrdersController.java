package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.ProductCart;
import za.ac.cput.service.orders.OrdersServiceImpl;
import za.ac.cput.service.productcart.ProductCartServiceImpl;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersServiceImpl ordersServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Orders orders) {
        try {
            Orders ordersCreated = ordersServiceImpl.create(orders);
            return ResponseEntity.ok(ordersCreated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getall")
    public List<Orders> getall(){
        return ordersServiceImpl.getAll();
    }

    @PostMapping("/update")
    public Orders update(@RequestBody Orders orders){
        return ordersServiceImpl.update(orders);
    }
}
