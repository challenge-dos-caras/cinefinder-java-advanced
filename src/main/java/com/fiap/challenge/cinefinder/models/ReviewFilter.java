package com.fiap.challenge.cinefinder.models;

public record ReviewFilter(
    Long userId,
    Long movieId,
    Double minRating,
    Double maxRating
) {
    
}
