package com.example.motbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.motbs.entities.Employee;
import com.example.motbs.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

		@Autowired
	    private EmployeeRepository employeeRepository;

		
		@Override		
	    public Employee addEmployee(Employee employee) {
			return employeeRepository.save(employee);
		}
		
		@Override
		public List<Employee> getAllEmployees() {
			return employeeRepository.findAll();
		}
		
		@Override
	    public Employee getByCode(String code) {
	        return employeeRepository.findByEmployeeCode(code)
	        		.orElseThrow(() -> new RuntimeException("Employee not found"));
	    }
		
		@Override
	    public List<Employee> searchByName(String name) {
	        return employeeRepository.findByNameContainingIgnoreCase(name);
	    }
		
		@Override
	    public List<Employee> filterByDepartment(String department) {
	        return employeeRepository.findByDepartmentIgnoreCase(department);
	    }
		
		@Override
	    public List<Employee> filterByStatus(String status) {
	        return employeeRepository.findByStatusIgnoreCase(status);
	    }

		@Override
	    public Employee updateEmployee(Long id, Employee updated) {
	        return employeeRepository.findById(id)
	                .map(emp -> {
	                    emp.setName(updated.getName());
	                    emp.setPosition(updated.getPosition());
	                    emp.setDepartment(updated.getDepartment());
	                    emp.setStatus(updated.getStatus());
	                    return employeeRepository.save(emp);
	                })
	                .orElseThrow(() -> new RuntimeException("Employee not found"));
	    }

		@Override
	    public void deleteEmployee(Long id) {
	        employeeRepository.deleteById(id);
	    }
		
	}

