package com.codersfree.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codersfree.prueba.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByEmail(String email);

    List<User> findByName(String name);

    List<User> findByNameContainingIgnoreCase(String name);

    List<User> findByNameAndEmail(String name, String email);

}
