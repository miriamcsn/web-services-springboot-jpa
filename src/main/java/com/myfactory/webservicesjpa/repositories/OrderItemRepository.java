package com.myfactory.webservicesjpa.repositories;

import com.myfactory.webservicesjpa.entities.Order;
import com.myfactory.webservicesjpa.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
