package com.fiap.challenge.cinefinder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fiap.challenge.cinefinder.models.Movie;
import com.fiap.challenge.cinefinder.repositories.MovieRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MovieService {

    @Autowired
    private MovieRepo repo;

    public Page<Movie> getAll(Specification<Movie> specs, Pageable pageable) {
        log.info("recuperando filmes");
        return repo.findAll(specs, pageable);
    }

    public Movie geById(Long id) {
        log.info("recuperando filme pelo id: {}", id);
        return getMovieById(id);
    }

    public void create(Movie movie) {
        log.info("criando filme: {}", movie);
        repo.save(movie);
    }

    public Movie updateById(Long id, Movie updMovie) {
        log.info("atualizando filme pelo id: {} | {}", id, updMovie);
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
