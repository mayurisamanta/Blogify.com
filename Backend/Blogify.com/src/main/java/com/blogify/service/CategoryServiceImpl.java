package com.blogify.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogify.dto.CategoryDto;
import com.blogify.entity.Category;
import com.blogify.exception.ResourceNotFoundException;
import com.blogify.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo cRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto dto) {
		Category category = dtoToCategory(dto);
		Category savedCategory = cRepo.save(category);
		CategoryDto categoryDto = CategoryToDto(savedCategory);
		return categoryDto;
	}

	@Override
	public CategoryDto updateCategory(CategoryDto dto, Integer categoryId) {
		Category category = cRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("User", "id", categoryId));
	    
		category.setDescription(dto.getDescription());
		category.setTitle(dto.getTitle());
	    
		Category updatedCategory = cRepo.save(category);
	    
		CategoryDto categoryDto = CategoryToDto(updatedCategory);
		return categoryDto;
	}

	@Override
	public CategoryDto getCategorybyId(Integer categoryId) {
		Category category = cRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("User", "id", categoryId));
		CategoryDto deletedCategory = CategoryToDto(category);
		return deletedCategory;
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categoryDto = cRepo.findAll();
		List<CategoryDto> categoryDtos = categoryDto.stream().map(c -> CategoryToDto(c)).collect(Collectors.toList());
		return categoryDtos;
	}

	@Override
	public CategoryDto deleteCategory(Integer categoryId) {
		Category category = cRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("User", "id", categoryId));
		CategoryDto deletedCategory = CategoryToDto(category);
		cRepo.delete(category);
		
		return deletedCategory;
	}
	
	public Category dtoToCategory(CategoryDto dto) {		
		Category category = modelMapper.map(dto, Category.class);
		return category;
	}
	
	public CategoryDto CategoryToDto(Category category) {		
		CategoryDto dto = modelMapper.map(category, CategoryDto.class);
		return dto;
	}

}
