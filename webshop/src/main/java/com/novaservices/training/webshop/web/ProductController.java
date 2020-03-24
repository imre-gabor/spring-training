package com.novaservices.training.webshop.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.novaservices.training.webshop.dao.ProductRepository;
import com.novaservices.training.webshop.model.Modify;
import com.novaservices.training.webshop.model.Product;
import com.novaservices.training.webshop.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductService productService;
	

	@GetMapping
	public List<Product> getAll(){
		return productRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Product getById(@PathVariable Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	//public ResponseEntity<Product> create(@RequestBody @Valid Product product) {...} --> default error json válasz
	public ResponseEntity<Product> create(@RequestBody @Valid Product product, BindingResult errors) {
		if(errors.hasErrors())
			throw new CustomException("Custom error message", 1234);
			//return ResponseEntity.badRequest().body("\"Custom error message\"");
		
		if(product.getId() != null)
			return ResponseEntity.badRequest().build();
		
		return ResponseEntity.ok(productRepository.save(product));
	}
	
//	@PutMapping
//	public Product modify(@RequestBody Product product) {
//		if(product.getId() == null)
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//		return productRepository.save(product);
//	}
	
	@PutMapping
	public Product modify(@RequestBody @Validated(Modify.class) Product product) {
		return productRepository.save(product);
	}

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		try {
			productRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {}
	}
	
	@PostMapping("/search1")
	public List<Product> search1(@RequestBody Product example){
		return productService.search1(example);
	}
	
}
