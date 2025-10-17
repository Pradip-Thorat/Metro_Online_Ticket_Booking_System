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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.motbs.entities.Employee;
import com.example.motbs.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin

public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.addEmployee(employee),HttpStatus.CREATED);
	}	
	@GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{code}")
    public Employee getByCode(@PathVariable String code) {
        return employeeService.getByCode(code);
    }

    @GetMapping("/search")
    public List<Employee> searchByName(@RequestParam String name) {
        return employeeService.searchByName(name);
    }

    @GetMapping("/department/{dept}")
    public List<Employee> filterByDepartment(@PathVariable String dept) {
        return employeeService.filterByDepartment(dept);
    }

    @GetMapping("/status/{status}")
    public List<Employee> filterByStatus(@PathVariable String status) {
        return employeeService.filterByStatus(status);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updated) {
        return employeeService.updateEmployee(id, updated);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

}
