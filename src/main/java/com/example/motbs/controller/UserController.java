package com.example.motbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.motbs.dtos.UserDto;
import com.example.motbs.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto)
	{
		return new ResponseEntity<UserDto>(userService.addUser(userDto),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto>updateUser(@PathVariable String id, @RequestBody UserDto userDto)
	{
		return ResponseEntity.ok(userService.updateUser(id, userDto));
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>>getAllUsers()
	{
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto>getUserById(@PathVariable String id)
	{
		return new ResponseEntity<UserDto>(userService.getUserById(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/findByEmail/{email}")
	public ResponseEntity<UserDto>getUserByEmail(@PathVariable String email)
	{
		return new ResponseEntity<UserDto>(userService.getUserByEmail(email),HttpStatus.FOUND);
	}
	
	@GetMapping("/findByFirstName/{firstName}")
	public ResponseEntity<List<UserDto>> getUserByFirstName(@PathVariable String firstName)
	{
		return new ResponseEntity<List<UserDto>>(userService.getUserByFirstName(firstName),HttpStatus.FOUND);
	}
	
	@GetMapping("/findByLastName/{lastName}")
	public ResponseEntity<List<UserDto>>getUserByLastName(@PathVariable String lastName)
	{
		return new ResponseEntity<List<UserDto>>(userService.getUserByLastName(lastName),HttpStatus.OK);
	}
}
