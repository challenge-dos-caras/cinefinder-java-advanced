package com.fiap.challenge.cinefinder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fiap.challenge.cinefinder.models.WatchList;
import com.fiap.challenge.cinefinder.repositories.WatchListRepo;

@Service
public class WatchListService {

    @Autowired
    private WatchListRepo repo;

    public Page<WatchList> getAll(Specification<WatchList> specs, Pageable pageable) {
        return repo.findAll(specs, pageable);
    }

    public WatchList geById(Long id) {
        return getWatchListById(id);
    }

    public void create(WatchList genre) {
        repo.save(genre);
    }

    public WatchList updateById(Long id, WatchList updWatchList) {
        updWatchList.setId(getWatchListById(id).getId());
        return repo.save(updWatchList);
    }

    public void deleteById(Long id) {
        repo.delete(getWatchListById(id));
    }

    private WatchList getWatchListById(Long id) {
        return repo.findById(id).orElseThrow();
    }

}
