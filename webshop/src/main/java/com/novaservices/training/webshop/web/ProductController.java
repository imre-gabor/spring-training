package com.novaservices.training.webshop.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.fasterxml.jackson.annotation.JsonView;
import com.novaservices.training.webshop.dao.ProductRepository;
import com.novaservices.training.webshop.dto.CategoryDto;
import com.novaservices.training.webshop.dto.ProductDto;
import com.novaservices.training.webshop.mapper.ProductMapper;
import com.novaservices.training.webshop.model.Category;
import com.novaservices.training.webshop.model.Modify;
import com.novaservices.training.webshop.model.Product;
import com.novaservices.training.webshop.model.Views;
import com.novaservices.training.webshop.service.ProductService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductService productService;
	

	@JsonView({Views.InternalWithCategories.class})
	@GetMapping
	public List<Product> getAll() {
		//return productRepository.findAll();
		
		
//		List<Product> products = productRepository.findAll();
		
		//1. megoldás JSON serialize problémára: kézzel nullozás
//		products.forEach(p ->{
//			Category category = p.getCategory();
//			if(category != null)
//				category.setProducts(null);
//		});
//		
		//2. megoldás: @JsonIgnore a Category.products mezőre --> túl durva, Category listázásnál sem látszanak a productok
		
		//3. megoldás: @JsonManaged/@JsonBackReference --> category listázás OK, de product listázásnál nem látszik a category
		
		//4. megoldás: @JsonIdentityInfo --> product listázáskor bizonyos productok csak id-vel fognak szerepelni
		//ha a category products listájában egyszer már szerializálva voltak
		List<Product> products = productRepository.findAllWithCategoriesProducts();
		
		//5. megoldás: @JsonView --> sok annotáció
		
		return products;
		
	}
	
	@GetMapping("/dto")
	public List<ProductDto> getAllDtos() {
		List<Product> allProducts = productRepository.findAll();
		
		//megoldás kézzel
//		List<ProductDto> dtos = new ArrayList<>();
//		for (Product product : allProducts) {
//			ProductDto productDto = new ProductDto();
//			productDto.setId(product.getId());
//			productDto.setName(product.getName());
//			productDto.setPrice(product.getPrice());
//			Category category = product.getCategory();
//			if(category != null) {
//				CategoryDto catDto = new CategoryDto();
//				productDto.setCategory(catDto);
//				catDto.setId(category.getId());
//				catDto.setName(category.getName());
//			}
//			
//			dtos.add(productDto);
//		}
//		
//		return dtos;
		return ProductMapper.INSTANCE.productsToDtos(allProducts);
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

	@PostMapping("/search2")
	public Page<Product> search2(@RequestBody Product example, Pageable pageable){
		return productService.search2(example, pageable);
	}
	
	@PostMapping("/search3")
	@ApiImplicitParams({
		@ApiImplicitParam(name="page", dataType = "integer", paramType = "query", defaultValue = "0",
				value = "Result page (0..N)"),
		@ApiImplicitParam(name="size", dataType = "integer", paramType = "query", defaultValue = "20",
			value = "Page size"),
		@ApiImplicitParam(name="sort", dataType = "string", paramType = "query", allowMultiple = true,
			value = "Sort fields, e.g. id,desc")
	})
	public Page<Product> search3(@RequestBody Product example, @ApiIgnore Pageable pageable){
		return productService.search3(example, pageable);
	}

	
}
