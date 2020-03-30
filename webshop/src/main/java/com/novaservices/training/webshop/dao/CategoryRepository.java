package com.novaservices.training.webshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novaservices.training.webshop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	List<Category> findByName(String name);

}
