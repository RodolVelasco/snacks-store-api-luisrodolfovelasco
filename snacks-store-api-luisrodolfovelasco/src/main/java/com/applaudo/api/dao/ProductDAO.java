package com.applaudo.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applaudo.api.model.Product;
import com.applaudo.api.repository.ProductRepository;

@Service
public class ProductDAO {
	
	@Autowired
	ProductRepository productRepository;
	
	public Product save(Product entity) {
		return productRepository.save(entity);
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findOne(Long productId) {
		return productRepository.findOne(productId);
	}
	
	public void delete(Product entity) {
		productRepository.delete(entity);
	}
}
