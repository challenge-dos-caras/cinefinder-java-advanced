package com.fiap.challenge.cinefinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.fiap.challenge.cinefinder.models.Genre;

public interface GenreRepo extends JpaRepository<Genre, Long>, JpaSpecificationExecutor<Genre> {
    
}
