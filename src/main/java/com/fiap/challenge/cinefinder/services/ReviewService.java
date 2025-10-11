package com.fiap.challenge.cinefinder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fiap.challenge.cinefinder.models.Review;
import com.fiap.challenge.cinefinder.repositories.ReviewRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReviewService {

    @Autowired
    private ReviewRepo repo;

    public Page<Review> getAll(Specification<Review> specs, Pageable pageable) {
        log.info("recuperando filmes");
        return repo.findAll(specs, pageable);
    }

    public Review geById(Long id) {
        log.info("recuperando avaliacoes pelo id: {}", id);
        return getReviewById(id);
    }

    public void create(Review review) {
        log.info("adicionando avaliacao: {}", review);
        repo.save(review);
    }

    public Review updateById(Long id, Review updReview) {
        updReview.setId(getReviewById(id).getId());
        return repo.save(updReview);
    }

    public void deleteById(Long id) {
        repo.delete(getReviewById(id));
    }

    private Review getReviewById(Long id) {
        return repo.findById(id).orElseThrow();
    }

}
