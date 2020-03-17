package com.novaservices.training.webshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novaservices.training.webshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
