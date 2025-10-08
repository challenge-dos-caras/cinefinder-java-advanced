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

    public Page<Genre> getAll(Specification<Genre> specs, Pageable pageable) {
        return repo.findAll(specs, pageable);
    }

    public Genre geById(Long id) {
        return getGenreById(id);
    }

    public void create(Genre genre) {
        repo.save(genre);
    }

    public Genre updateById(Long id, Genre updGenre) {
        updGenre.setId(getGenreById(id).getId());
        return repo.save(updGenre);
    }

    public void deleteById(Long id) {
        repo.delete(getGenreById(id));
    }

    private Genre getGenreById(Long id) {
        return repo.findById(id).orElseThrow();
    }

}
