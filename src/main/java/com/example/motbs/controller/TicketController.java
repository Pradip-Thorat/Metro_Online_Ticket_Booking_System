package com.example.motbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.motbs.entities.Ticket;
import com.example.motbs.service.TicketService;

@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = "http://localhost:5173")

public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/{book}")
	public ResponseEntity<Ticket> bookTicket(@RequestParam String userId,
											@RequestParam String sourceName,
											@RequestParam String destinationName)
	{
        Ticket ticket = ticketService.bookTicket(userId, sourceName, destinationName);
        return ResponseEntity.ok(ticket);

	}
	
	@GetMapping
	public ResponseEntity<List<Ticket>>getAllTickets()
	{
		return ResponseEntity.ok(ticketService.getAllTickets());
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable Long id)
	{
		return new ResponseEntity<Ticket>(ticketService.getTicketById(id),HttpStatus.FOUND);
	}

}
