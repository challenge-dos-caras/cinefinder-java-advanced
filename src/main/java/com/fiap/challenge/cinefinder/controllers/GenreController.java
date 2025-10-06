package com.fiap.challenge.cinefinder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.challenge.cinefinder.models.Genre;
import com.fiap.challenge.cinefinder.models.GenreFilter;
import com.fiap.challenge.cinefinder.services.GenreService;

@RestController
@RequestMapping("genres")
public class GenreController {
    
    @Autowired
    private GenreService service;

    @GetMapping
    public Page<Genre> index(GenreFilter filters, @PageableDefault(size = 15) Pageable pageable) {
        return null;
    }


}
