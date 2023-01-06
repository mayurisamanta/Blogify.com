package com.blogify.service;

import java.util.List;

import com.blogify.dto.UserDto;

public interface UserService {

	public UserDto createUser(UserDto dto);
	
	public UserDto updateUser(UserDto dto, Integer userId);
	
	public UserDto getUserbyId(Integer userId);
	
	public List<UserDto> getAllUser();
	
	public UserDto deleteUser(Integer userId);
}
