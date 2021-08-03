package com.myfactory.webservicesjpa.services;

import com.myfactory.webservicesjpa.entities.Product;
import com.myfactory.webservicesjpa.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Component //registra sua classe como componente do Spring e ele vai poder injeta-la automaticamente em outros locais com o @Autowired
//porém, Component é muito genérica. Existem anotações de Component mais específicas! Repository, Service... nesse caso, usaremos Service.
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

//    @GetMapping
//    public ResponseEntity<Product> findAll() {
//        Product u2 = new Product(2L, "Miriam", "miriam@gmail.com", "9999999", "12345");
//        productRepository.save(u2);
//        return ResponseEntity.ok().body(productRepository.getById(2L));

    public List<Product> findAll() {  // camada de serviço passando pra camada de repositório <3
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);  //optional é um utilitário meio q curinga
        return obj.get(); //retorna um objeto tipo Product que tenha o id fornecido e esteja dentro de Optional
    }

}
