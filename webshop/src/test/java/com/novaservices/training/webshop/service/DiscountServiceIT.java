package com.novaservices.training.webshop.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.novaservices.training.webshop.dao.ProductRepository;
import com.novaservices.training.webshop.model.Product;

@SpringBootTest
@AutoConfigureTestDatabase
//@Transactional
//@ActiveProfiles("test") //--> alternatív megoldás a @Transactional helyett, a @DirtiesContext-tel együtt
public class DiscountServiceIT {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	DiscountService discountService;
	
	
	@Test
//	@DirtiesContext
	void testThatPricesOfMatchingProductsAreDecreasedAfterDiscountByName() throws Exception {
		
		//ARRANGE
		productRepository.save(new Product("abc", 100.0));
		productRepository.save(new Product("abc", 200.0));
		productRepository.save(new Product("def", 100.0));
		
		//ACT
		discountService.discountProductsByName("abc", 10);
		
		//ASSERT
		List<Product> productsAfterDiscount = productRepository.findAll(Sort.by("id"));
		assertThat(productsAfterDiscount).hasSize(3);
		Offset<Double> offset = Offset.offset(0.00001);
		assertThat(productsAfterDiscount.get(0).getPrice()).isCloseTo(90.0, offset);
		assertThat(productsAfterDiscount.get(1).getPrice()).isCloseTo(180.0, offset);
		assertThat(productsAfterDiscount.get(2).getPrice()).isCloseTo(100.0, offset);
	}
	
	@Test
//	@DirtiesContext
	void testThatPricesOfMatchingProductsAreDecreasedAfterDiscountByName2() throws Exception {
		
		//ARRANGE
		productRepository.save(new Product("abc", 100.0));
		productRepository.save(new Product("abc", 200.0));
		productRepository.save(new Product("def", 100.0));
		
		//ACT
		discountService.discountProductsByName("abc", 10);
		
		//ASSERT
		List<Product> productsAfterDiscount = productRepository.findAll(Sort.by("id"));
		assertThat(productsAfterDiscount).hasSize(3);
		Offset<Double> offset = Offset.offset(0.00001);
		assertThat(productsAfterDiscount.get(0).getPrice()).isCloseTo(90.0, offset);
		assertThat(productsAfterDiscount.get(1).getPrice()).isCloseTo(180.0, offset);
		assertThat(productsAfterDiscount.get(2).getPrice()).isCloseTo(100.0, offset);
	}
	
	
}
