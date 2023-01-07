package com.blogify.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private Integer user_id;
	
	@NotNull(message = "Name should not be null")
	@NotBlank(message = "Name should not be blank")
	private String name;
	
	@Email(message = "Invalid email")
	private String email;
	
	@NotNull
	private String password;
	
	@NotNull
	private String about;

}
