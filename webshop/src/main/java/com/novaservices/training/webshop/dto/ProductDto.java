package com.novaservices.training.webshop.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.novaservices.training.webshop.model.Modify;

public class ProductDto {
	
	@NotNull(groups = Modify.class)
	private Long id;
	
	@Size(min = 5, max = 10)
	@NotNull
	private String name;
	
	private Double price;
	
	private CategoryDto category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

}
