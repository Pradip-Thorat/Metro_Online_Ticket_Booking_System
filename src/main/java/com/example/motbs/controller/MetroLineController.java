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

import com.example.motbs.entities.MetroLine;
import com.example.motbs.service.MetroLineService;

@RestController
@RequestMapping("/metroLines")
@CrossOrigin(origins = "http://localhost:5173") // allow your frontend server

public class MetroLineController {
	
	@Autowired
	private MetroLineService metroLineService;
	
	@PostMapping
	public ResponseEntity<MetroLine> addMetroLine(@RequestBody MetroLine metroLine)
	{
		return new ResponseEntity<MetroLine>(metroLineService.addMetroLine(metroLine),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<MetroLine>> getAllMetroLines()
	{
		return ResponseEntity.ok(metroLineService.getAllMetroLines());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MetroLine> getMetroLineById(@PathVariable Long id)
	{
		return ResponseEntity.ok(metroLineService.getById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MetroLine> updateMetroLine(@PathVariable Long id, @RequestBody MetroLine metroLine)
	{
		return ResponseEntity.ok(metroLineService.updateMetroLine(id, metroLine));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MetroLine> deleteRoute(@PathVariable Long id)
	{
		MetroLine metroLine = metroLineService.getById(id);
		metroLineService.deleteById(id);
		return ResponseEntity.ok(metroLine);
	}

	@GetMapping("/line/{lineName}")
	public ResponseEntity<List<MetroLine>> getRoutesByLine(@PathVariable String lineName)
	{
		return ResponseEntity.ok(metroLineService.getRoutesByLineName(lineName));
	}
}
