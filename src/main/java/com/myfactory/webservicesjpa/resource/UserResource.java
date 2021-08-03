package com.myfactory.webservicesjpa.resource;

import com.myfactory.webservicesjpa.entities.User;
import com.myfactory.webservicesjpa.repositories.UserRepository;
import com.myfactory.webservicesjpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
//        return ResponseEntity.ok().body(userService.findAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

//    public ResponseEntity<User> findAll(@RequestParam String name, @RequestParam String phone) {
        //        User u = new User(1L, name, "maria@gmail.com", phone, "12345");


}