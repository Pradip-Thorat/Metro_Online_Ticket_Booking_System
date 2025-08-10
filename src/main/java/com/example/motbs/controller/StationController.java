package com.example.motbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.motbs.entities.Station;
import com.example.motbs.service.StationService;

@RestController
@RequestMapping("/stations")

public class StationController {
	
	@Autowired
	private StationService stationService;
	
	@PostMapping
	public ResponseEntity<Station> addStation(@RequestBody Station station)
	{
		return new ResponseEntity<Station>(stationService.addStation(station),HttpStatus.CREATED);
	}

}
