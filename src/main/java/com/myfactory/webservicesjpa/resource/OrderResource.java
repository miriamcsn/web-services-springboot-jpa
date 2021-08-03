package com.myfactory.webservicesjpa.resource;

import com.myfactory.webservicesjpa.entities.Order;
import com.myfactory.webservicesjpa.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orders = orderService.findAll();
        return ResponseEntity.ok().body(orders);
//        return ResponseEntity.ok().body(orderService.findAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.findById(id));
    }

//    public ResponseEntity<Order> findAll(@RequestParam String name, @RequestParam String phone) {
        //        Order u = new Order(1L, name, "maria@gmail.com", phone, "12345");


}