package com.novaservices.training.webshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.novaservices.training.webshop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	List<Category> findByName(String name);

	@EntityGraph(attributePaths = {"products"})
	@Query("SELECT c FROM Category c")
	List<Category> findAllWithProducts();
}
