package com.fiap.challenge.cinefinder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fiap.challenge.cinefinder.models.WatchList;
import com.fiap.challenge.cinefinder.repositories.WatchListRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WatchListService {

    @Autowired
    private WatchListRepo repo;

    public Page<WatchList> getAll(Specification<WatchList> specs, Pageable pageable) {
        log.info("recuperando listas de filmes");
        return repo.findAll(specs, pageable);
    }

    public WatchList geById(Long id) {
        log.info("recuperando lista de filme pelo id: {}", id);
        return getWatchListById(id);
    }

    public void create(WatchList watchList) {
        log.info("adicionando lista de filme: {}", watchList);
        repo.save(watchList);
    }

    public WatchList updateById(Long id, WatchList updWatchList) {
        log.info("atualizando list de filmes pelo id: {} | {}", id, updWatchList);
        updWatchList.setId(getWatchListById(id).getId());
        return repo.save(updWatchList);
    }

    public void deleteById(Long id) {
        log.info("deletando lista de filme pelo id: {}", id);
        repo.delete(getWatchListById(id));
    }

    private WatchList getWatchListById(Long id) {
        return repo.findById(id).orElseThrow();
    }

}
