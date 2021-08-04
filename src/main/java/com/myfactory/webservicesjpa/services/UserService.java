package com.myfactory.webservicesjpa.services;

import com.myfactory.webservicesjpa.entities.User;
import com.myfactory.webservicesjpa.repositories.UserRepository;
import com.myfactory.webservicesjpa.services.exceptions.DatabaseException;
import com.myfactory.webservicesjpa.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import java.util.List;

//@Component //registra sua classe como componente do Spring e ele vai
// poder injeta-la automaticamente em outros locais com o @Autowired
// Porém, Component é muito genérica. Existem anotações de Component mais específicas!
// Repository, Service... nesse caso, usaremos Service.
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {  // camada de serviço passando pra camada de repositório <3
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
            // assim, lança uma exceção da minha camada de servico
        }
    }

    public User update(Long id, User obj) {

        try {
            User entity = userRepository.getOne(id);
            //getOne is deprecated, tried replacing by findById or findOne but neither did work =/
            updateData(entity, obj);
            return userRepository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
        // só esses três, não vou querer que atualize id nem senha!
    }
}
