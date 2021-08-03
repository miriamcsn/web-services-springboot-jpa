package com.myfactory.webservicesjpa.resource;

import com.myfactory.webservicesjpa.entities.User;
import com.myfactory.webservicesjpa.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<User> findAll(@RequestParam String name, @RequestParam String phone) {
        User u = new User(1L, name, "maria@gmail.com", phone, "12345");
//        User u2 = new User(2L, def, "miriam@gmail.com", "9999999", "12345");
        userRepository.save(u);
//        userRepository.save(u2);

        return ResponseEntity.ok().body(userRepository.getById(1L));


    }
}