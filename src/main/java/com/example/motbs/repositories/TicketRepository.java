package com.example.motbs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.motbs.entities.Station;
import com.example.motbs.entities.Ticket;

@CrossOrigin
@RepositoryRestResource(path = "ticket")
public interface TicketRepository extends JpaRepository<Ticket, Long>{

	
	
}
