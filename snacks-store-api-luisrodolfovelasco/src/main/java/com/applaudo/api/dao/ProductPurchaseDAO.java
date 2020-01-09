package com.applaudo.api.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applaudo.api.model.ProductPurchase;
import com.applaudo.api.repository.ProductPurchaseRepository;

@Service
public class ProductPurchaseDAO {
	
	@Autowired
	ProductPurchaseRepository productPurchaseRepository;
	
	public ProductPurchase save(ProductPurchase entity) {
		return productPurchaseRepository.save(entity);
	}
	
	public List<ProductPurchase> findAll(){
		return productPurchaseRepository.findAll();
	}
	
	public Optional<ProductPurchase> findOne(Long productPurchaseId) {
		return productPurchaseRepository.findById(productPurchaseId);
	}
	
	public ProductPurchase findOneByName(String name) {
		return productPurchaseRepository.findOneByProductName(name);
	}
	
	public void delete(ProductPurchase entity) {
		productPurchaseRepository.delete(entity);
	}
}
