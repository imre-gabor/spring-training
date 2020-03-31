package com.novaservices.training.webshop.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.novaservices.training.webshop.dto.CategoryDto;
import com.novaservices.training.webshop.dto.ProductDto;
import com.novaservices.training.webshop.model.Category;
import com.novaservices.training.webshop.model.Product;

@Mapper
public interface CategoryMapper {
	
	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

	List<CategoryDto> categoriesToDtos(List<Category> categories);
	
	@Mapping(target = "category", ignore = true)
	ProductDto productToDto(Product product);
}
