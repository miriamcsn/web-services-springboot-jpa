package com.myfactory.webservicesjpa.services;

import com.myfactory.webservicesjpa.entities.User;
import com.myfactory.webservicesjpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Optional;

import java.util.List;

//@Component //registra sua classe como componente do Spring e ele vai poder injeta-la automaticamente em outros locais com o @Autowired
//porém, Component é muito genérica. Existem anotações de Component mais específicas! Repository, Service... nesse caso, usaremos Service.
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @GetMapping
//    public ResponseEntity<User> findAll() {
//        User u2 = new User(2L, "Miriam", "miriam@gmail.com", "9999999", "12345");
//        userRepository.save(u2);
//        return ResponseEntity.ok().body(userRepository.getById(2L));

    public List<User> findAll() {  // camada de serviço passando pra camada de repositório <3
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);  //optional é um utilitário meio q curinga
        return obj.get(); //retorna um objeto tipo User que tenha o id fornecido e esteja dentro de Optional
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id, User obj) {
        User entity = userRepository.getOne(id);
        //getOne is deprecated, tried replacing by findById or findOne but neither did work =/
        updateData(entity, obj);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
        // só esses três, não vou querer que atualize id nem senha!
    }
}
