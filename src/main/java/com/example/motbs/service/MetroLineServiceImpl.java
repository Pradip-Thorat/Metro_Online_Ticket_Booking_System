package com.example.motbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.motbs.entities.MetroLine;

import com.example.motbs.repositories.MetroLineRepository;

@Service
public class MetroLineServiceImpl implements MetroLineService {

	@Autowired
	private MetroLineRepository metroLineRepository;
	
	@Override
	public MetroLine addMetroLine(MetroLine metroLine) {
		return metroLineRepository.save(metroLine);
	}
	
	@Override
	public List<MetroLine> getAllMetroLines() {
		return metroLineRepository.findAll();
	}
	
	@Override
	public MetroLine getById(Long id) {
		return metroLineRepository.findById(id).orElse(null);
	}
	
	@Override
	public MetroLine updateMetroLine(Long id, MetroLine metroLine) {
		MetroLine fetchedRoute = metroLineRepository.findById(id)
				.orElseThrow(()->new RuntimeException("Id not found"));
		
		fetchedRoute.setLineName(metroLine.getLineName());
		fetchedRoute.setLineColor(metroLine.getLineColor());
		
		MetroLine updatedRoute = metroLineRepository.save(fetchedRoute);
		
		return updatedRoute;
	}
	
	@Override
	public void deleteById(Long id) {
		MetroLine metroLine = metroLineRepository.findById(id)
		.orElseThrow(()->new RuntimeException("Id not found"));
		
		metroLineRepository.delete(metroLine);
	}

    @Override
    public List<MetroLine> getRoutesByLineName(String lineName) {
        return metroLineRepository.findByLineName(lineName);
    }
}
