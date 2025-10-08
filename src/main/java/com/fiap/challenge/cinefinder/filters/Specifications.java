package com.fiap.challenge.cinefinder.filters;

import org.springframework.data.jpa.domain.Specification;

import com.fiap.challenge.cinefinder.models.Genre;
import com.fiap.challenge.cinefinder.models.GenreFilter;
import com.fiap.challenge.cinefinder.models.Movie;
import com.fiap.challenge.cinefinder.models.MovieFilter;
import com.fiap.challenge.cinefinder.models.Review;
import com.fiap.challenge.cinefinder.models.ReviewFilter;
import com.fiap.challenge.cinefinder.models.User;
import com.fiap.challenge.cinefinder.models.UserFilter;
import com.fiap.challenge.cinefinder.models.WatchList;
import com.fiap.challenge.cinefinder.models.WatchListFilter;

public class Specifications {

    public static Specification<Genre> buildGenreSpecification(GenreFilter filter) {
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

    public static Specification<Movie> buildMovieSpecification(MovieFilter filter) {
        return (root, query, cb) -> {
            var predicates = cb.conjunction();

            if (filter.title() != null) {
                var predicateTitle = cb.like(
                        cb.upper(root.get("title")),
                        "%" + filter.title().toUpperCase() + "%");
                predicates = cb.and(predicates, predicateTitle);
            }

            if (filter.description() != null) {
                var predicateDescription = cb.like(
                        cb.upper(root.get("name")),
                        "%" + filter.description().toUpperCase() + "%");
                predicates = cb.and(predicates, predicateDescription);
            }

            if (filter.starDate() != null) {
                var predicateStartDate = cb.greaterThanOrEqualTo(
                        root.get("releaseDate"),
                        filter.starDate());
                predicates = cb.and(predicates, predicateStartDate);
            }

            if (filter.endDate() != null) {
                var predicateEndDate = cb.lessThanOrEqualTo(
                        root.get("releaseDate"),
                        filter.endDate());
                predicates = cb.and(predicates, predicateEndDate);

            }

            if (filter.minRating() != null) {
                var predicateMinRating = cb.greaterThanOrEqualTo(
                        root.get("averageRating"),
                        filter.minRating());
                predicates = cb.and(predicates, predicateMinRating);

            }

            if (filter.maxRating() != null) {
                var predicateMaxRating = cb.lessThanOrEqualTo(
                        root.get("averageRating"),
                        filter.maxRating());
                predicates = cb.and(predicates, predicateMaxRating);
            }

            if (filter.genresIds() != null || !filter.genresIds().isEmpty()) {
                var predicateGenres = root.join("genres").get("id").in(filter.genresIds());
                predicates = cb.and(predicates, predicateGenres);

                query.distinct(true);
            }

            return predicates;
        };
    }

    public static Specification<Review> buildReviewSpecification(ReviewFilter filter) {

        return (root, query, cb) -> {
            var predicates = cb.conjunction();

            if (filter.userId() != null) {
                var predicateUser = cb.equal(root.get("user_id"), filter.userId());
                predicates = cb.and(predicates, predicateUser);
            }

            if (filter.movieId() != null) {
                var predicateUser = cb.equal(root.get("movie_id"), filter.movieId());
                predicates = cb.and(predicates, predicateUser);
            }

            if (filter.minRating() != null) {
                var predicateMinRating = cb.greaterThanOrEqualTo(
                        root.get("averageRating"),
                        filter.minRating());
                predicates = cb.and(predicates, predicateMinRating);

            }

            if (filter.maxRating() != null) {
                var predicateMaxRating = cb.lessThanOrEqualTo(
                        root.get("averageRating"),
                        filter.maxRating());
                predicates = cb.and(predicates, predicateMaxRating);

            }

            return predicates;
        };
    }

    public static Specification<User> buildUserSpecification(UserFilter filter) {
        return (root, query, cb) -> {
            var predicates = cb.conjunction();

            if (filter.name() != null) {
                var predicateName = cb.like(
                        cb.upper(root.get("name")),
                        "%" + filter.name().toUpperCase() + "%");
                predicates = cb.and(predicates, predicateName);
            }

            if (filter.minAge() != null) {
                var predicateMinAge = cb.greaterThanOrEqualTo(
                        root.get("age"),
                        filter.minAge());
                predicates = cb.and(predicates, predicateMinAge);

            }

            if (filter.maxAge() != null) {
                var predicateMaxAge = cb.lessThanOrEqualTo(
                        root.get("age"),
                        filter.maxAge());
                predicates = cb.and(predicates, predicateMaxAge);
            }

            return predicates;
        };
    }

    public static Specification<WatchList> buildWatchListSpecification(WatchListFilter filter) {

        return (root, query, cb) -> {

            var predicates = cb.conjunction();

            if (filter.name() != null) {
                var predicateTitle = cb.like(
                        cb.upper(root.get("name")),
                        "%" + filter.name().toUpperCase() + "%");
                predicates = cb.and(predicates, predicateTitle);
            }

            
            if (filter.moviesIds() != null || !filter.moviesIds().isEmpty()) {
                var predicateMovies = root.join("movies").get("id").in(filter.moviesIds());
                predicates = cb.and(predicates, predicateMovies);

                query.distinct(true);
            }

            return predicates;

        };
    }

}
