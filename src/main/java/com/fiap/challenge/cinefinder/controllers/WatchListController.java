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
import com.fiap.challenge.cinefinder.models.WatchList;
import com.fiap.challenge.cinefinder.models.WatchListFilter;
import com.fiap.challenge.cinefinder.services.WatchListService;

@RestController
@RequestMapping("watch-lists")
public class WatchListController {
    
    @Autowired
    private WatchListService service;

    @GetMapping
    public Page<WatchList> getAllWatchLists(WatchListFilter filters, @PageableDefault(size = 15) Pageable pageable) {
        var specs = Specifications.buildWatchListSpecification(filters);
        return service.getAll(specs, pageable);
    }


    @GetMapping("{id}")
    public WatchList getWatchListById(@PathVariable Long id) {
        return service.geById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createWatchList(@RequestBody WatchList WatchList) {
        service.create(WatchList);
    }

    @PutMapping("{id}")
    public WatchList updateWatchList(@PathVariable Long id, @RequestBody WatchList updWatchList) {
        return service.updateById(id, updWatchList);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT )
    public void deleteWatchList(@PathVariable Long id) {
        service.deleteById(id);
    }
}
