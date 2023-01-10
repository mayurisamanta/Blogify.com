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

import com.blogify.dto.CategoryDto;
import com.blogify.service.CategoryService;

@RestController
@RequestMapping("/blogify/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService cSer;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategoryHandler(@Valid @RequestBody CategoryDto dto){
		CategoryDto createdCategoryDto = cSer.createCategory(dto);
		return new ResponseEntity<CategoryDto>(createdCategoryDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategoryHandler(@Valid @RequestBody CategoryDto dto, @PathVariable("categoryId") Integer categoryId){
		CategoryDto updatedCategoryDto = cSer.updateCategory(dto, categoryId);
		return new ResponseEntity<CategoryDto>(updatedCategoryDto, HttpStatus.OK);
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategorybyIdHandler(@PathVariable("userId") Integer categoryId){
		CategoryDto categoryDto = cSer.getCategorybyId(categoryId);
		return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.FOUND);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategoryHandler(){
		List<CategoryDto> categoryDtos = cSer.getAllCategory();
		return new ResponseEntity<List<CategoryDto>>(categoryDtos, HttpStatus.FOUND);
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> deleteCategoryHandler(@PathVariable("categoryId") Integer categoryId){
		CategoryDto deletedCategoryDto = cSer.deleteCategory(categoryId);
		return new ResponseEntity<CategoryDto>(deletedCategoryDto, HttpStatus.OK);
	}

}
