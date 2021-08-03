package com.myfactory.webservicesjpa.resource;

import com.myfactory.webservicesjpa.entities.User;
import com.myfactory.webservicesjpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u2 = new User(2L, "Miriam", "miriam@gmail.com", "9999999", "12345");
        userRepository.save(u2);
        return ResponseEntity.ok().body(userRepository.getById(2L));

//    public ResponseEntity<User> findAll(@RequestParam String name, @RequestParam String phone) {
        //        User u = new User(1L, name, "maria@gmail.com", phone, "12345");

    }
}