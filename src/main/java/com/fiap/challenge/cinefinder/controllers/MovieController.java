package com.fiap.challenge.cinefinder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.challenge.cinefinder.filters.Specifications;
import com.fiap.challenge.cinefinder.models.Movie;
import com.fiap.challenge.cinefinder.models.MovieFilter;
import com.fiap.challenge.cinefinder.services.MovieService;

@RestController
@RequestMapping("movies")
public class MovieController {
    
    @Autowired
    private MovieService service;

    @GetMapping
    public Page<Movie> getAllMovies(MovieFilter filters, @PageableDefault(size = 15) Pageable pageable) {
        var specs = Specifications.buildMovieSpecification(filters);
        return service.getAll(specs, pageable);
    }


    @GetMapping("{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return service.geById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createMovie(@RequestBody Movie Movie) {
        service.create(Movie);
    }

    @PutMapping("{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie updMovie) {
        return service.updateById(id, updMovie);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT )
    public void deleteMovie(@PathVariable Long id) {
        service.deleteById(id);
    }
}
