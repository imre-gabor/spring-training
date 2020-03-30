package com.novaservices.training.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.convert.QueryByExamplePredicateBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.novaservices.training.webshop.dao.CategoryRepository;
import com.novaservices.training.webshop.dao.ProductRepository;
import com.novaservices.training.webshop.model.Category;
import com.novaservices.training.webshop.model.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	

	public List<Product> search1(Product example) {
		//Example<Product> ex = Example.of(example); --> default konfig: null-ok szerint nem szűr, de üres stringre igen, és pontos egyezés kell
		Example<Product> ex = createExample(example); 
		return productRepository.findAll(ex);
	}


	private Example<Product> createExample(Product example) {
		Example<Product> ex = Example.of(example,
				defaultMatcher()
				);
		return ex;
	}
	
	private Example<Product> createExample(Product example, ExampleMatcher matcher) {
		Example<Product> ex = Example.of(example,matcher);
		return ex;
	}


	private ExampleMatcher defaultMatcher() {
		return ExampleMatcher.matching()
		//.withStringMatcher(StringMatcher.STARTING)
		.withIgnoreCase()
		.withTransformer("name", s -> s.filter(s2 -> ((String)s2).length() > 0));
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
	
	public Page<Product> search3(Product example, Pageable pageable) {
		Specification<Product> combinedSpec = Specification.where(null);
		
		if(example.getPrice() != null)
			combinedSpec = combinedSpec.and(byPriceWithin(example, 10));
		
		//első megoldás: kézzel állítjuk be a többi property-re is a kritériumokat
//		if(example.getId() != null)
//			combinedSpec = combinedSpec.and((product, cq, cb) -> cb.equal(product.get("id"), example.getId()));
//		
//		if(StringUtils.hasLength(example.getName()))
//			combinedSpec = combinedSpec.and((product, cq, cb) -> cb.like(product.get("name"), example.getName() + "%"));
		
		//második megoldás: használjuk újra azt, amit az Example-s keresés már tud
		combinedSpec = combinedSpec.and(byFieldsExceptPrice(example));
		
		return productRepository.findAll(combinedSpec, pageable);
	}
	
	
	private Specification<Product> byPriceWithin(Product example, int percent) {
		return (product, cq, cb) -> 
			cb.between(
				product.get("price"), 
				example.getPrice()*(100.0-percent)/100, 
				example.getPrice()*(100.0+percent)/100);
	}
	
	private Specification<Product> byFieldsExceptPrice(Product example) {
		return (root, cq, cb) -> QueryByExamplePredicateBuilder.getPredicate(root, cb, 
				createExample(example, 
						defaultMatcher()
						.withIgnorePaths("price")
						.withStringMatcher(StringMatcher.STARTING))) 
			;
	}
	
	@Transactional
	public Product createProductWithCategory(Product product, String categoryName) {
		List<Category> categories = categoryRepository.findByName(categoryName);
		Category category = null;
		if(categories.isEmpty()) {
			category = new Category();
			category.setName(categoryName);
			category = categoryRepository.save(category);
		} else {
			category = categories.get(0);
		}
		
		product = productRepository.save(product);
		category.addProduct(product);
		return product;
	}
	
}
