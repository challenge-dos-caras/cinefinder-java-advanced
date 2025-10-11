package com.fiap.challenge.cinefinder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fiap.challenge.cinefinder.models.User;
import com.fiap.challenge.cinefinder.repositories.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepo repo;

    public Page<User> getAll(Specification<User> specs, Pageable pageable) {
        log.info("recuperando usuarios");
        return repo.findAll(specs, pageable);
    }

    public User geById(Long id) {
        log.info("recuperando usuario pelo id: {}", id);
        return getUserById(id);
    }

    public void create(User user) {
        log.info("adicionando usuario: {}", user);
        repo.save(user);
    }

    public User updateById(Long id, User updUser) {
        log.info("atualizando usuario pelo id: {} | {}", id, updUser);
        updUser.setId(getUserById(id).getId());
        return repo.save(updUser);
    }

    public void deleteById(Long id) {
        log.info("deletando usuario pelo id: {}", id);
        repo.delete(getUserById(id));
    }

    private User getUserById(Long id) {
        return repo.findById(id).orElseThrow();
    }

}
