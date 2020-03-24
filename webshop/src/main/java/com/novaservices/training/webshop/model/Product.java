package com.novaservices.training.webshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {

	@Id
	@NotNull(groups = Modify.class)
	@GeneratedValue
	private Long id;
	
	@Size(min = 5, max = 10)
	@NotNull
	private String name;
	private Double price;
	
	public Product() {
	}
	
	public Product(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
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
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
