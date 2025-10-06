package com.fiap.challenge.cinefinder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fiap.challenge.cinefinder.models.Genre;
import com.fiap.challenge.cinefinder.repositories.GenreRepo;

@Service
public class GenreService {

    @Autowired
    private GenreRepo repo;

    public Page<Genre> getGenres(Specification<Genre> specs, Pageable pageable) {
        return repo.findAll(specs, pageable);
    }

    
}
