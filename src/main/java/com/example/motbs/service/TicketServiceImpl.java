package com.example.motbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.motbs.entities.MetroLine;
import com.example.motbs.entities.Station;
import com.example.motbs.entities.Ticket;
import com.example.motbs.entities.User;
import com.example.motbs.repositories.MetroLineRepository;
import com.example.motbs.repositories.StationRepository;
import com.example.motbs.repositories.TicketRepository;
import com.example.motbs.repositories.UserRepository;

@Service

public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MetroLineRepository metroLineRepository;
	
	@Autowired
	private StationRepository stationRepository;

	@Override
	public Ticket bookTicket(String userId,String sourceName,String destinationName)
	{
		System.out.println(destinationName);
		    User user = userRepository.findById(userId)
		            .orElseThrow(() -> new RuntimeException("User not found"));

		    Station source = stationRepository.findByName(sourceName)
		            .orElseThrow(() -> new RuntimeException("Source station not found: " + sourceName));

		    Station destination = stationRepository.findByName(destinationName)
		            .orElseThrow(() -> new RuntimeException("Destination station not found: " + destinationName));

//		    Route route = routeRepository.findRouteBySourceAndDest(source.getId(), destination.getId())
//		            .orElseThrow(() -> new RuntimeException(
//		                    "Route not found between " + sourceName + " and " + destinationName
//		            ));

		    double fare = calculateFare(source, destination);

		    Ticket ticket = new Ticket();
		    ticket.setUser(user);
		    ticket.setSource(source);
		    ticket.setDestination(destination);
		    ticket.setStatus("BOOKED");
		    ticket.setFare(fare);

		    return ticketRepository.save(ticket);
	}
	
	@Override
	public List<Ticket> getAllTickets(){
		return ticketRepository.findAll();
	}
	
	@Override
	public Ticket getTicketById(Long id) {
		return ticketRepository.findById(id).orElseThrow(null);
	}
	
	@Override
	public void deleteById(Long id) {
		Ticket ticket = ticketRepository.findById(id)
		.orElseThrow(()->new RuntimeException("Id not found"));
		
		ticketRepository.delete(ticket);
	}
	
	private double calculateFare(Station source, Station destination) {
	    Long diff = Math.abs(source.getId() - destination.getId());

	    if (diff <= 3) {
	        return 10.0;
	    } else if (diff <= 6) {
	        return 20.0;
	    } else if (diff <= 9) {
	        return 30.0;
	    } else {
	        return 40.0;
	    }
	}


}
