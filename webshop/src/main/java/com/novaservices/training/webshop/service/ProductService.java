package com.novaservices.training.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.novaservices.training.webshop.dao.ProductRepository;
import com.novaservices.training.webshop.model.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	

	public List<Product> search1(Product example) {
		//Example<Product> ex = Example.of(example); --> default konfig: null-ok szerint nem szűr, de üres stringre igen, és pontos egyezés kell
		Example<Product> ex = createExample(example); 
		return productRepository.findAll(ex);
	}


	private Example<Product> createExample(Product example) {
		Example<Product> ex = Example.of(example,
				ExampleMatcher.matching()
				//.withStringMatcher(StringMatcher.STARTING)
				.withIgnoreCase()
				.withTransformer("name", s -> s.filter(s2 -> ((String)s2).length() > 0))
				);
		return ex;
	}


	public Page<Product> search2(Product example, Pageable pageable) {
		return productRepository.findAll(createExample(example), pageable);
	}

	
	public List<Product> findByPrice(Product example) {
		
		return productRepository.findAll(byPrice(example));
	}

	private Specification<Product> byPrice(Product example) {
		return (product, cq, cb) -> cb.equal(product.get("price"), example.getPrice());
	}
	
	public List<Product> search3(Product example) {
		Specification<Product> combinedSpec = Specification.where(null);
		
		if(example.getPrice() != null)
			combinedSpec = combinedSpec.and(byPriceWithin(example, 10));
		
		if(example.getId() != null)
			combinedSpec = combinedSpec.and((product, cq, cb) -> cb.equal(product.get("id"), example.getId()));
		
		if(example.getName() != null)
			combinedSpec = combinedSpec.and((product, cq, cb) -> cb.like(product.get("name"), example.getName() + "%"));
		
		return productRepository.findAll(combinedSpec);
	}
	
	
	private Specification<Product> byPriceWithin(Product example, int percent) {
		return (product, cq, cb) -> 
			cb.between(
				product.get("price"), 
				example.getPrice()*(100.0-percent)/100, 
				example.getPrice()*(100.0+percent)/100);
	}
	
}
