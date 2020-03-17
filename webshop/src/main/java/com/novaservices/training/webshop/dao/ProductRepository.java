package com.novaservices.training.webshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novaservices.training.webshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByName(String name);

}
