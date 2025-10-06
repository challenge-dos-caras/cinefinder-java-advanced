package com.fiap.challenge.cinefinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.fiap.challenge.cinefinder.models.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long>, JpaSpecificationExecutor<Movie> {
    
}
