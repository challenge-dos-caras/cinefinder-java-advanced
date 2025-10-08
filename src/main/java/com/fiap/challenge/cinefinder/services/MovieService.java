package com.fiap.challenge.cinefinder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fiap.challenge.cinefinder.models.Movie;
import com.fiap.challenge.cinefinder.repositories.MovieRepo;

@Service
public class MovieService {

    @Autowired
    private MovieRepo repo;

    public Page<Movie> getAll(Specification<Movie> specs, Pageable pageable) {
        return repo.findAll(specs, pageable);
    }

    public Movie geById(Long id) {
        return getMovieById(id);
    }

    public void create(Movie genre) {
        repo.save(genre);
    }

    public Movie updateById(Long id, Movie updMovie) {
        updMovie.setId(getMovieById(id).getId());
        return repo.save(updMovie);
    }

    public void deleteById(Long id) {
        repo.delete(getMovieById(id));
    }

    private Movie getMovieById(Long id) {
        return repo.findById(id).orElseThrow();
    }

}
