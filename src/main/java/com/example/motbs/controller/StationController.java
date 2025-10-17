package com.example.motbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.motbs.dtos.UserDto;
import com.example.motbs.entities.Station;
import com.example.motbs.service.StationService;

@RestController
@RequestMapping("/stations")
@CrossOrigin

public class StationController {
	
	@Autowired
	private StationService stationService;
	
	@GetMapping
	public ResponseEntity<List<Station>>getAllStations()
	{
		return ResponseEntity.ok(stationService.getAllStations());
	}
	
	@PostMapping
	public ResponseEntity<Station> addStation(@RequestBody Station station)
	{
		return new ResponseEntity<Station>(stationService.addStation(station),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Station> getStationById(@PathVariable int id)
	{
		return new ResponseEntity<Station>(stationService.getById(id),HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Station> updateStation(@PathVariable int id, @RequestBody Station station)
	{
		return ResponseEntity.ok(stationService.updateStation(id, station));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Station> deleteStation(@PathVariable int id)
	{
		Station station = stationService.getById(id);
		stationService.deleteById(id);
		return ResponseEntity.ok(station);
	}

}
