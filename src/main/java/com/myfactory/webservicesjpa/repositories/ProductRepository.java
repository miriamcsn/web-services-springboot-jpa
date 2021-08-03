package com.myfactory.webservicesjpa.repositories;

import com.myfactory.webservicesjpa.entities.Category;
import com.myfactory.webservicesjpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
