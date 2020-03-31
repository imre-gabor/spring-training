package com.novaservices.training.webshop.web;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.novaservices.training.webshop.model.Product;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
@Transactional
public class ProductControllerIT {

	@Autowired
	MockMvc mvc;
	
	@Test
	void testSaveProduct() throws Exception {
		
		//ARRANGE
		Product product1 = new Product("prod1", 100.0);

		//ACT
		mvc.perform(post("/api/products")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(product1))
				)
		//ASSERT		
			.andExpect(status().isOk());
		
		mvc.perform(
			get("/api/products")
			.contentType(MediaType.APPLICATION_JSON)
			)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(1)))
			.andExpect(jsonPath("$[0].name", is(product1.getName())))
			.andExpect(jsonPath("$[0].price", is(product1.getPrice())));
	}
	
	@Test
	void testSaveProduct2() throws Exception {
		
		//ARRANGE
		Product product1 = new Product("prod1", 100.0);

		//ACT
		mvc.perform(post("/api/products")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(product1))
				)
		//ASSERT		
			.andExpect(status().isOk());
		
		mvc.perform(
			get("/api/products")
			.contentType(MediaType.APPLICATION_JSON)
			)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(1)))
			.andExpect(jsonPath("$[0].name", is(product1.getName())))
			.andExpect(jsonPath("$[0].price", is(product1.getPrice())));
	}
	
}
