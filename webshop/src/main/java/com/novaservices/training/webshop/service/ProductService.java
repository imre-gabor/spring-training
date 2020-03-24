package com.novaservices.training.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.novaservices.training.webshop.dao.ProductRepository;
import com.novaservices.training.webshop.model.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	

	public List<Product> search1(Product example) {
		//Example<Product> ex = Example.of(example); --> default konfig: null-ok szerint nem szűr, de üres stringre igen, és pontos egyezés kell
		Example<Product> ex = Example.of(example,
				ExampleMatcher.matching()
				//.withStringMatcher(StringMatcher.STARTING)
				.withIgnoreCase()
				.withTransformer("name", s -> s.filter(s2 -> ((String)s2).length() > 0))
				); 
		
		return productRepository.findAll(ex);
	}

}
