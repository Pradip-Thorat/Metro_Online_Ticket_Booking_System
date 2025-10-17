package com.example.motbs.service;

import java.util.List;

import com.example.motbs.entities.Employee;

public interface EmployeeService {
	
	Employee addEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee getByCode(String code);
	
	List<Employee> searchByName(String name);
	
	List<Employee> filterByDepartment(String department);
	
	List<Employee> filterByStatus(String status);
	
	Employee updateEmployee(Long id, Employee updated);
	
	void deleteEmployee(Long id);

}
