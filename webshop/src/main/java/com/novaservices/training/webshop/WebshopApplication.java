package com.novaservices.training.webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.novaservices.training.webshop.dao.ProductRepository;
import com.novaservices.training.webshop.model.Product;
import com.novaservices.training.webshop.service.DiscountService;
import com.novaservices.training.webshop.service.ProductService;

@SpringBootApplication
public class WebshopApplication implements CommandLineRunner {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	DiscountService discountService;
	
	@Autowired
	ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(WebshopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		productRepository.save(new Product("abc", 100.0));
		productRepository.save(new Product("abc", 200.0));
		productRepository.save(new Product("def", 200.0));
		discountService.discountProductsByName("abc", 10);
		productRepository.findAll().forEach(System.out::println);
		*/
		
		/*
		productService.createProductWithCategory(new Product("product1_1", 100.0),  "cat1");
		productService.createProductWithCategory(new Product("product1_2", 100.0),  "cat1");
		
		productService.createProductWithCategory(new Product("product2_1", 100.0),  "cat2");
		productService.createProductWithCategory(new Product("product2_2", 100.0),  "cat2");
		*/
	}

}
