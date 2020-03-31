package com.novaservices.training.webshop.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.novaservices.training.webshop.dao.CategoryRepository;
import com.novaservices.training.webshop.dto.CategoryDto;
import com.novaservices.training.webshop.mapper.CategoryMapper;
import com.novaservices.training.webshop.model.Category;
import com.novaservices.training.webshop.model.Views;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@JsonView(Views.WithProducts.class)
	@GetMapping
	public List<Category> getAll(){
		return categoryRepository.findAllWithProducts();
	}
	
	@GetMapping("/dto")
	public List<CategoryDto> getAllDtos(){
		return CategoryMapper.INSTANCE
				.categoriesToDtos(categoryRepository.findAllWithProducts());
	}
	
}
