package com.blogify.service;

import java.util.List;

import com.blogify.dto.CategoryDto;

public interface CategoryService {

	public CategoryDto createCategory(CategoryDto dto);
	
	public CategoryDto updateCategory(CategoryDto dto, Integer categoryId);
	
	public CategoryDto getCategorybyId(Integer categoryId);
	
	public List<CategoryDto> getAllCategory();
	
	public CategoryDto deleteCategory(Integer categoryId);
}
