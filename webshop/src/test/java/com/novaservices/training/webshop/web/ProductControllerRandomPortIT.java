package com.novaservices.training.webshop.web;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.novaservices.training.webshop.model.Product;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
//@Transactional --> nem hozza a várt eredményt, mert másik szálon fut a webkonténer
//az ottani tranzakciók mindenképp commitolnak
@ActiveProfiles("test")
public class ProductControllerRandomPortIT {

	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	@DirtiesContext
	void testSaveProduct() throws Exception {
		
		//ARRANGE
		Product product1 = new Product("prod1", 100.0);

		//ACT

		ResponseEntity<Product> response = restTemplate.postForEntity("/api/products", product1, Product.class);
		
		//ASSERT		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getId()).isNotNull();
		
		ResponseEntity<List<Product>> responseList = restTemplate.exchange("/api/products", HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {});
		assertThat(responseList.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<Product> products = responseList.getBody();
		
		assertThat(products).hasSize(1);
		Product returnedProduct = products.get(0);
		assertThat(returnedProduct).isEqualToIgnoringGivenFields(product1, "id");
		
	}

	@Test
	@DirtiesContext
	void testSaveProduct2() throws Exception {
		
		//ARRANGE
		Product product1 = new Product("prod1", 100.0);

		//ACT

		ResponseEntity<Product> response = restTemplate.postForEntity("/api/products", product1, Product.class);
		
		//ASSERT		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getId()).isNotNull();
		
		ResponseEntity<List<Product>> responseList = restTemplate.exchange("/api/products", HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {});
		assertThat(responseList.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<Product> products = responseList.getBody();
		
		assertThat(products).hasSize(1);
		Product returnedProduct = products.get(0);
		assertThat(returnedProduct).isEqualToIgnoringGivenFields(product1, "id");
		
	}

}
