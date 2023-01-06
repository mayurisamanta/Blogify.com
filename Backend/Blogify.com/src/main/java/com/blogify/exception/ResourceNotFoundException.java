package com.blogify.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

	String resourceName;
	
	String fieldName;
	
	Integer fieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValue) {
		super(String.format("%s not found with %f : %v", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
}
