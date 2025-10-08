package com.fiap.challenge.cinefinder.models;

public record UserFilter(
    String name, 
    Integer minAge,
    Integer maxAge) {

}
