package com.fiap.challenge.cinefinder.filters;

import org.springframework.data.jpa.domain.Specification;

import com.fiap.challenge.cinefinder.models.Genre;
import com.fiap.challenge.cinefinder.models.GenreFilter;

public class GenreSpecification {

    public static Specification<Genre> build(GenreFilter filter) {
        return (root, query, cb) -> {
            var predicates = cb.conjunction();

            if (filter.name() != null) {
                var predicateName = cb.like(
                    cb.upper(root.get("name")), 
                    "%" + filter.name().toUpperCase() + "%");
                    predicates = cb.and(predicates, predicateName);
            }

            return predicates;
        };
    }

}
