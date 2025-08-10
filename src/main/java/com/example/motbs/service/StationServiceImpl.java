package com.example.motbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.motbs.entities.Station;
import com.example.motbs.repositories.StationRepository;

@Service

public class StationServiceImpl implements StationService {
	
	@Autowired
	private StationRepository stationRepository;
	
	@Override
	public Station addStation(Station station) {
		return stationRepository.save(station);
	}


}
