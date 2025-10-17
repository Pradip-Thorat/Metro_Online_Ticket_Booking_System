package com.example.motbs.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.motbs.entities.MetroLine;
import com.example.motbs.entities.Station;

@CrossOrigin
@RepositoryRestResource(path = "metroline")
public interface MetroLineRepository extends JpaRepository<MetroLine, Long> {
    
    List<MetroLine> findByLineName(String lineName);
	
}
