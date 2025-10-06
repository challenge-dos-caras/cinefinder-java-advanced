package com.fiap.challenge.cinefinder.models;

import java.time.LocalDate;
import java.util.List;

public record MovieFilter(
    String title,
    String description,
    LocalDate starDate,
    LocalDate endDate,
    Double maxRating,
    Double minRating,
    List<Long> genresIds
) {
    
}
