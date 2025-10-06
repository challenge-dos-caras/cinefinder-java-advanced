package com.fiap.challenge.cinefinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.fiap.challenge.cinefinder.models.Review;

public interface ReviewRepo extends JpaRepository<Review, Long>, JpaSpecificationExecutor<Review> {
    
}
