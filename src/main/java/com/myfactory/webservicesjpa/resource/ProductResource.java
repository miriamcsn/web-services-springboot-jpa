package com.myfactory.webservicesjpa.resource;

import com.myfactory.webservicesjpa.entities.Product;
import com.myfactory.webservicesjpa.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok().body(products);
//        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.findById(id));
    }

//    public ResponseEntity<Product> findAll(@RequestParam String name, @RequestParam String phone) {
        //        Product u = new Product(1L, name, "maria@gmail.com", phone, "12345");


}