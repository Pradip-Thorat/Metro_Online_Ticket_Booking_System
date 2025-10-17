package com.example.motbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.motbs.entities.Station;
import com.example.motbs.entities.Ticket;

@Service

public interface TicketService {
	
	public Ticket bookTicket(String userId,String sourceName,String destinationName);
	
	List<Ticket>getAllTickets();
	
	Ticket getTicketById(Long id);
	
	void deleteById(Long id);

}
