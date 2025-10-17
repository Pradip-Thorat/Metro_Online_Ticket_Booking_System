package com.example.motbs.service;

import java.util.List;

import com.example.motbs.dtos.UserDto;
import com.example.motbs.entities.User;

public interface UserService {
	
	UserDto addUser(UserDto userDto);
	
	UserDto updateUser(String id,UserDto userDto);
	
	List<UserDto>getAllUsers();
	
	UserDto getUserById(String id);
	
	UserDto getUserByEmail(String email);
	
	List<UserDto>getUserByFirstName(String firstName);
	
	List<UserDto>getUserByLastName(String lastName);
	
	UserDto entityToDto(User user);
	
	User dtoToEntity(UserDto userDto);

}
