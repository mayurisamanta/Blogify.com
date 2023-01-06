package com.blogify.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogify.dto.UserDto;
import com.blogify.entity.User;
import com.blogify.exception.ResourceNotFoundException;
import com.blogify.repository.UserRepo;

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo uRepo;

	@Override
	public UserDto createUser(UserDto dto) {
		User user = dtoToUser(dto);
		User savedUser = uRepo.save(user);
		UserDto userDto = userToDto(savedUser);
		return userDto;
	}

	@Override
	public UserDto updateUser(UserDto dto, Integer userId) {
	    User user = uRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
	    
	    user.setName(dto.getName());
	    user.setEmail(dto.getEmail());
	    user.setAbout(dto.getAbout());
	    user.setPassword(dto.getPassword());
	    
	    User updatedUser = uRepo.save(user);
	    
	    UserDto userDto = userToDto(updatedUser);
		return userDto;
	}

	@Override
	public UserDto getUserbyId(Integer userId) {
		User user = uRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
		UserDto userDto = userToDto(user);
		return userDto;
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = uRepo.findAll();
		List<UserDto> userDtos = users.stream().map(u -> userToDto(u)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public UserDto deleteUser(Integer userId) {
		User user = uRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
		UserDto userDto = userToDto(user);
		uRepo.delete(user);
		return userDto;
	}
	
	public User dtoToUser(UserDto dto) {
		User user = new User(dto.getUser_id(), dto.getName(), dto.getName(), dto.getEmail(), dto.getAbout());
		return user;
	}
	
	public UserDto userToDto(User user) {
		UserDto dto = new UserDto(user.getUser_id(), user.getName(), user.getEmail(), user.getPassword(), user.getAbout());
		return dto;
	}

}
