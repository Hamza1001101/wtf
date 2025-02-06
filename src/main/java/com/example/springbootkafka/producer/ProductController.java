//package com.example.springbootkafka.producer;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/products")
//public class ProductController {
//
//    final ProductService service;
//
//    public ProductController(ProductService service) {
//        this.service = service;
//    }
//
//
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping
//    public List<Product> findAll() {
//        return service.findAll();
//    }
//
//    @PostMapping
//    public void save(@RequestBody Product product) {
//        service.save(product);
//    }
//}
