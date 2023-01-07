package com.blogify.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUserHandler(@Valid @RequestBody UserDto dto){
		UserDto createdUserDto = uSer.createUser(dto);
		return new ResponseEntity<UserDto>(createdUserDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUserHandler(@Valid @RequestBody UserDto dto, @PathVariable("userId") Integer userId){
		UserDto updatedUserDto = uSer.updateUser(dto, userId);
		return new ResponseEntity<UserDto>(updatedUserDto, HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserbyIdHandler(@PathVariable("userId") Integer userId){
		UserDto userDto = uSer.getUserbyId(userId);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.FOUND);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUserHandler(){
		List<UserDto> userDtos = uSer.getAllUser();
		return new ResponseEntity<List<UserDto>>(userDtos, HttpStatus.FOUND);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<UserDto> deleteUserHandler(@PathVariable("userId") Integer userId){
		UserDto deletedUserDto = uSer.deleteUser(userId);
		return new ResponseEntity<UserDto>(deletedUserDto, HttpStatus.OK);
	}
}
