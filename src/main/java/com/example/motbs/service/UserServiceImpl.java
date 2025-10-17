package com.example.motbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.motbs.dtos.UserDto;
import com.example.motbs.entities.User;
import com.example.motbs.exceptions.UserNotFoundException;
import com.example.motbs.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDto addUser(UserDto userDto) {
		User savedUser = userRepository.save(dtoToEntity(userDto));
		return entityToDto(savedUser);
	}
	
	@Override
	public UserDto updateUser(String id,UserDto userDto) {
		User user = userRepository.findById(id)
				.orElseThrow(()->new UserNotFoundException("User Not Found"));
		
		userDto.setId(id);
		User savedUser=userRepository.save(dtoToEntity(userDto));
		
		return entityToDto(savedUser);
	}
	
	@Override
	public List<UserDto>getAllUsers(){
//		List<User> users=userRepository.findAll();
//		List<UserDto> list = users.stream().map(u->entityToDto(u)).toList();
//		return list;
		
		return userRepository.findAll().stream().map(u->entityToDto(u)).toList();
	}
	
	@Override
	public UserDto getUserById(String id)
	{
		User user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException());
		return entityToDto(user);
	}
	
	@Override
	public UserDto getUserByEmail(String email)
	{
		User user =userRepository.findByEmail(email).orElseThrow(()->new UserNotFoundException("User not found"));
		return entityToDto(user);
	}
	
	@Override
	public List<UserDto> getUserByFirstName(String firstName){
		return userRepository.findByFirstName(firstName).stream().map(u->entityToDto(u)).toList();
	}
	
	@Override
	public List<UserDto> getUserByLastName(String lastName){
		return userRepository.findByLastName(lastName).stream().map(v->entityToDto(v)).toList();
	}
	
	@Override
	public UserDto entityToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setPassword(user.getPassword());
		userDto.setEmail(user.getEmail());
		userDto.setAge(user.getAge());
		userDto.setPhoneno(user.getPhoneno());
		return userDto;
	}
	
	@Override
	public User dtoToEntity(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setAge(userDto.getAge());
		user.setPhoneno(userDto.getPhoneno());
		return user;
	}

}
