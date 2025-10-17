package com.example.motbs.service;

import java.util.List;
import java.util.Optional;

import com.example.motbs.entities.MetroLine;
import com.example.motbs.entities.Station;


public interface MetroLineService {
	
	MetroLine addMetroLine(MetroLine metroLine);
	
	List<MetroLine> getAllMetroLines();
	
	MetroLine getById(Long id);
	
	MetroLine updateMetroLine(Long id,MetroLine metroLine);
	
	void deleteById(Long id);

	List<MetroLine> getRoutesByLineName(String lineName);
}
