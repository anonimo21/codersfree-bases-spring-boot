package com.codersfree.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codersfree.prueba.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
