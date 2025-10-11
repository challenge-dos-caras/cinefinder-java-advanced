package com.fiap.challenge.cinefinder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fiap.challenge.cinefinder.models.Genre;
import com.fiap.challenge.cinefinder.repositories.GenreRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GenreService {

    @Autowired
    private GenreRepo repo;

    public Page<Genre> getAll(Specification<Genre> specs, Pageable pageable) {
        log.info("recuperando genêros de filme");
        return repo.findAll(specs, pageable);
    }

    public Genre geById(Long id) {
        log.info("recuperando genêros de filme pelo id: {}", id);
        return getGenreById(id);
    }

    public void create(Genre genre) {
        log.info("criando genêro de filme: {}", genre);
        repo.save(genre);
    }

    public Genre updateById(Long id, Genre updGenre) {
        log.info("atualizando genêro de filme pelo id: {} | {}", id, updGenre);
        updGenre.setId(getGenreById(id).getId());
        return repo.save(updGenre);
    }

    public void deleteById(Long id) {
        log.info("deletando genêro de filme pelo id: {}", id);
        repo.delete(getGenreById(id));
    }

    private Genre getGenreById(Long id) {
        return repo.findById(id).orElseThrow();
    }

}
