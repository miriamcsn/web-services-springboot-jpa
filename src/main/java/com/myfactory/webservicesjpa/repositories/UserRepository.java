package com.myfactory.webservicesjpa.repositories;

import com.myfactory.webservicesjpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // essa anotacao nao seria necessaria porque UserRepository esta estendendo de JpaRepository
// que já é registrado como Repository nos Components do Spring.
// mas eu quis deixar assim mesmo!
public interface UserRepository extends JpaRepository<User,Long> {

}
