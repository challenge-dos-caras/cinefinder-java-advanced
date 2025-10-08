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
import com.fiap.challenge.cinefinder.models.Review;
import com.fiap.challenge.cinefinder.models.ReviewFilter;
import com.fiap.challenge.cinefinder.services.ReviewService;

@RestController
@RequestMapping("reviews")
public class ReviewController {
    
    @Autowired
    private ReviewService service;

    @GetMapping
    public Page<Review> getAllReviews(ReviewFilter filters, @PageableDefault(size = 15) Pageable pageable) {
        var specs = Specifications.buildReviewSpecification(filters);
        return service.getAll(specs, pageable);
    }


    @GetMapping("{id}")
    public Review getReviewById(@PathVariable Long id) {
        return service.geById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createReview(@RequestBody Review Review) {
        service.create(Review);
    }

    @PutMapping("{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review updReview) {
        return service.updateById(id, updReview);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT )
    public void deleteReview(@PathVariable Long id) {
        service.deleteById(id);
    }
}
