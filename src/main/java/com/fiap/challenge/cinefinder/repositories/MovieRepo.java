package com.fiap.challenge.cinefinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.fiap.challenge.cinefinder.models.Movie;

public interface MovieRepo extends JpaRepository<Movie, Long>, JpaSpecificationExecutor<Movie> {
    
}
