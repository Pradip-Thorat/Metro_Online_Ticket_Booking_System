package com.example.motbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.motbs.entities.Station;

@RepositoryRestResource(path = "station")
public interface StationRepository extends JpaRepository<Station, Long> {

}
