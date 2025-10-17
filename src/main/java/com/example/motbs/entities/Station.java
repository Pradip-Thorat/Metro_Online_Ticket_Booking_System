package com.example.motbs.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station {
	
	@Id
	private Long id;
	
	@Column(nullable = false,unique = true, length = 50)
	private String name;
	
	@Column(nullable = false,length = 50)
	private String code;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "metroline_id")
	private MetroLine metroLine;

	

}
