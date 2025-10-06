package com.fiap.challenge.cinefinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.fiap.challenge.cinefinder.models.WatchList;

public interface WatchListRepo extends JpaRepository<WatchList, Long>, JpaSpecificationExecutor<WatchList> {
    
}
