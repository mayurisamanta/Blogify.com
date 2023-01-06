package com.blogify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogify.dto.UserDto;
import com.blogify.service.UserService;

@RestController
@RequestMapping("/blogify/users")
public class UserController {

	@Autowired
	private UserService uSer;
	
	@GetMapping("/")
	public ResponseEntity<UserDto> createUserHandler(@RequestBody UserDto dto){
		UserDto userDto = uSer.createUser(dto);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);
	}
}
