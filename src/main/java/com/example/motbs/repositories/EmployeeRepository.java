package com.example.motbs.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.motbs.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	 Optional<Employee> findByEmployeeCode(String employeeCode);
	 
	 List<Employee> findByNameContainingIgnoreCase(String name);
	 
	 List<Employee> findByDepartmentIgnoreCase(String department);
	 
	 List<Employee> findByStatusIgnoreCase(String status);
	 
}

