package com.novaservices.training.webshop.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.novaservices.training.webshop.model.Product;

@Service
public class SimpleProductService {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Product save(Product product) {
		em.persist(product);
		return product;
	}
	
	@Transactional
	public Product update(Product product) {
		return em.merge(product);
	}
	
	public Product findById(Long id) {
		return em.find(Product.class, id);
	}
	
	@Transactional
	public void delete(Product product) {
		em.remove(em.merge(product));
	}
}
