package com.applaudo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.applaudo.api.model.ProductPurchase;

public interface ProductPurchaseRepository extends JpaRepository<ProductPurchase, Long> {
	
	public ProductPurchase findOneByProductName(String name);
}
