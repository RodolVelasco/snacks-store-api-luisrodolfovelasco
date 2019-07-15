package com.applaudo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.applaudo.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public Product findOneByName(String name);
	
}
