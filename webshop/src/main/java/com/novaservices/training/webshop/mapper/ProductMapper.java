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
public interface ProductMapper {

	public ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	List<ProductDto> productsToDtos(List<Product> products);
	
	@Mapping(target = "products", ignore = true)
	CategoryDto categoryToDto(Category category);
}
