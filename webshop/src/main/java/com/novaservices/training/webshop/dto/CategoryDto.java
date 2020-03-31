package com.novaservices.training.webshop.dto;

import java.util.Set;

public class CategoryDto {

	private Long id;
	
	private String name;
	
	private Set<ProductDto> products;

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

	public Set<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductDto> products) {
		this.products = products;
	}
}
