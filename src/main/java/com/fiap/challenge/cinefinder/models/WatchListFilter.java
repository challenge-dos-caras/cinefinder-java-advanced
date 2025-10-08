package com.fiap.challenge.cinefinder.models;

import java.util.List;

public record WatchListFilter(
    String name,
    List<Long> moviesIds) {

}
