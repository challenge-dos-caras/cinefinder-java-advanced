package com.fiap.challenge.cinefinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.fiap.challenge.cinefinder.models.User;

public interface UserRepo extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    
}
