package com.myfactory.webservicesjpa.repositories;

import com.myfactory.webservicesjpa.entities.Order;
import com.myfactory.webservicesjpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
