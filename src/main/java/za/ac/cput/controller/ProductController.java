package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.User;
import za.ac.cput.service.product.ProductServiceImpl;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Product product) {
        try {
            Product createdProduct = productServiceImpl.create(product);
            return ResponseEntity.ok(createdProduct);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getall")
    public List<Product> getall(){
        return productServiceImpl.getAll();
    }

    @GetMapping("/read/{id}")
    public Product read(@PathVariable long id){
        return productServiceImpl.read(id);
    }
}
