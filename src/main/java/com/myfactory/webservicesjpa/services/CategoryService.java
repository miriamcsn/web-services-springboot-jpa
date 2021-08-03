package com.myfactory.webservicesjpa.services;

import com.myfactory.webservicesjpa.entities.Category;
import com.myfactory.webservicesjpa.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Component //registra sua classe como componente do Spring e ele vai poder injeta-la automaticamente em outros locais com o @Autowired
//porém, Component é muito genérica. Existem anotações de Component mais específicas! Repository, Service... nesse caso, usaremos Service.
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

//    @GetMapping
//    public ResponseEntity<Category> findAll() {
//        Category u2 = new Category(2L, "Miriam", "miriam@gmail.com", "9999999", "12345");
//        categoryRepository.save(u2);
//        return ResponseEntity.ok().body(categoryRepository.getById(2L));

    public List<Category> findAll() {  // camada de serviço passando pra camada de repositório <3
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);  //optional é um utilitário meio q curinga
        return obj.get(); //retorna um objeto tipo Category que tenha o id fornecido e esteja dentro de Optional
    }

}
