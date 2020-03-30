package com.novaservices.training.webshop.client;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.novaservices.training.webshop.client.api.ProductControllerApi;
import com.novaservices.training.webshop.client.invoker.ApiClient;
import com.novaservices.training.webshop.client.model.Product;

@SpringBootApplication
public class WebshopClientApplication implements CommandLineRunner {

	@Autowired
	ProductControllerApi productControllerApi;
	
	public static void main(String[] args) {
		SpringApplication.run(WebshopClientApplication.class, args);
	}
	
	@Bean
	@Primary
	public ApiClient apiClient() {
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath("http://localhost:8080");
		return apiClient;
	}

	@Override
	public void run(String... args) throws Exception {
		Product example = new Product();
		example.setPrice(190.0);
		productControllerApi.search3UsingPOST(example, 0, 1, Arrays.asList("id,desc"))
		.getContent().stream().forEach(System.out::println);
	}

}
