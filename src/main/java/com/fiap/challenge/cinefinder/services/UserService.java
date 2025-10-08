package com.fiap.challenge.cinefinder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fiap.challenge.cinefinder.models.User;
import com.fiap.challenge.cinefinder.repositories.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public Page<User> getAll(Specification<User> specs, Pageable pageable) {
        return repo.findAll(specs, pageable);
    }

    public User geById(Long id) {
        return getUserById(id);
    }

    public void create(User genre) {
        repo.save(genre);
    }

    public User updateById(Long id, User updUser) {
        updUser.setId(getUserById(id).getId());
        return repo.save(updUser);
    }

    public void deleteById(Long id) {
        repo.delete(getUserById(id));
    }

    private User getUserById(Long id) {
        return repo.findById(id).orElseThrow();
    }

}
