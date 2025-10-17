package com.example.motbs.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	private String confirmPassword;
	
	private int age;
	
	private String email;
	
	private String phoneno;
	
}
