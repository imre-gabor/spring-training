package com.novaservices.training.webshop.service;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.novaservices.training.webshop.dao.ProductRepository;
import com.novaservices.training.webshop.model.Product;

@ExtendWith(MockitoExtension.class)
public class DiscountServiceTest {
	
	@InjectMocks
	DiscountService discountService;
	
	@Mock
	ProductRepository productRepository;

	//nem kell a MockitoExtension miatt
//	@BeforeEach
//	void init() {
//		MockitoAnnotations.initMocks(this);
//	}

	@Test
	void testThatPricesOfProductsWithGivenNameAreDecreased() throws Exception {
		
		//ARRANGE
		String productName = "abc";
		
		List<Product> products = Arrays.asList(
				new Product(productName, 100.0), 
				new Product(productName, 200.0));
		
		when(productRepository.findByName(productName)).thenReturn(products);
		
		//ACT
		discountService.discountProductsByName(productName, 10);

		//ASSERT
		Offset<Double> offset = offset(0.00001);
		assertThat(products.get(0).getPrice()).isCloseTo(90.0, offset);
		assertThat(products.get(1).getPrice()).isCloseTo(180.0, offset);
		
	}

	
	
	
}
