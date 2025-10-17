package com.example.motbs.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(unique = true, nullable = false, length = 20)
	    private String employeeCode; // e.g. EMP001

	    @Column(nullable = false)
	    private String name;

	    private String position;     // e.g. Station Manager
	    private String department;   // e.g. Operations
	    private String status;       // Active / On Leave
	    

}
