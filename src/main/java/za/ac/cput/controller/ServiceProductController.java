package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ServiceProduct;
import za.ac.cput.service.product.ProductServiceImpl;
import za.ac.cput.service.serviceproduct.ServiceProductServiceImpl;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/serviceproduct")
public class ServiceProductController {

    @Autowired
    private ServiceProductServiceImpl serviceProductServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ServiceProduct serviceProduct) {
        try {
            ServiceProduct createdServiceProduct = serviceProductServiceImpl.create(serviceProduct);
            return ResponseEntity.ok(createdServiceProduct);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getall")
    public List<ServiceProduct> getall(){
        return serviceProductServiceImpl.getAll();
    }

    @GetMapping("/read/{serviceProductId}")
    public ServiceProduct read(@PathVariable long serviceProductId) {
        return serviceProductServiceImpl.read(serviceProductId);

    }
}
