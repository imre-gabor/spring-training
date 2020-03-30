package com.novaservices.training.webshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.novaservices.training.webshop.model.Category;
import com.novaservices.training.webshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product>{

	List<Product> findByName(String name);

	@EntityGraph(attributePaths = {"category.products"})
	@Query("SELECT p FROM Product p")
	List<Product> findAllWithCategoriesProducts();
}
