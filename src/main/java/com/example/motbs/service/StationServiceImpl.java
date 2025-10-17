package com.example.motbs.service;

import java.util.List;

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
	
	@Override
	public Station getById(int id) {
		Station station = stationRepository.findById(id)
		.orElseThrow(()->new RuntimeException("Id not found"));
		return station;
	}
	
	@Override
	public List<Station> getAllStations() {
		return stationRepository.findAll();
	}
	
	@Override
	public Station updateStation(int id,Station station) {
		Station fetchedStation = stationRepository.findById(id)
				.orElseThrow(()->new RuntimeException("Id not found"));
		
		fetchedStation.setId(station.getId());
		fetchedStation.setName(station.getName());
		fetchedStation.setCode(station.getCode());
		
		Station updatedStation = stationRepository.save(fetchedStation);
		
		return updatedStation;
	}
	
	@Override
	public void deleteById(int id) {
		Station station = stationRepository.findById(id)
		.orElseThrow(()->new RuntimeException("Id not found"));
		
		stationRepository.delete(station);	
	}
	
}
