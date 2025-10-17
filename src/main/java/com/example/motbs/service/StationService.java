package com.example.motbs.service;

import java.util.List;

import com.example.motbs.entities.Station;

public interface StationService {
	
	Station addStation(Station station);
	
	Station getById(int id);
	
	List<Station> getAllStations();
	
	Station updateStation(int id,Station station);
	
	void deleteById(int id);
	

}
