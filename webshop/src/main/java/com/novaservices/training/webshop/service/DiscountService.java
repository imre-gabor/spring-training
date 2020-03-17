package com.novaservices.training.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.novaservices.training.webshop.dao.ProductRepository;

@Service
public class DiscountService {

	@Autowired
	private ProductRepository productRepository;

	@Transactional
	public void discountProductsByName(String name, int percent) {

		productRepository.findByName(name).forEach(product -> {
			product.setPrice(product.getPrice() * (100.0 - percent) / 100);
		});
	}
}
