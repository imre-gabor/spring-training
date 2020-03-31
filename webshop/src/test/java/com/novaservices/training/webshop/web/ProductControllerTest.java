package com.novaservices.training.webshop.web;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.novaservices.training.webshop.dao.ProductRepository;
import com.novaservices.training.webshop.model.Category;
import com.novaservices.training.webshop.model.Product;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
//@AutoConfigureTestDatabase --> a biztonság kedvéért
public class ProductControllerTest {

	@Autowired
	MockMvc mvc;
	
	@MockBean
	ProductRepository productRepository;
	
	@Test
	void testGetAll() throws Exception {
		
		//ARRANGE
		Product product1 = new Product("prod1", 100.0);
		product1.setId(10L);
		Product product2 = new Product("prod2", 200.0);
		product2.setId(20L);
		Category cat = new Category();
		cat.setId(100L);
		cat.setName("cat");
		cat.addProduct(product1);
		
		List<Product> products = Arrays.asList(product1, product2);
		
		when(productRepository.findAllWithCategoriesProducts()).thenReturn(products);
		
		//ACT
		mvc.perform(
			get("/api/products")
			.contentType(MediaType.APPLICATION_JSON)
			)
		//ASSERT
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(2)))
			.andExpect(jsonPath("$[0].name", is(product1.getName())))
			.andExpect(jsonPath("$[0].category.name", is(cat.getName())))
			.andExpect(jsonPath("$[0].category.products").doesNotExist());
			
		
	}
	
}
