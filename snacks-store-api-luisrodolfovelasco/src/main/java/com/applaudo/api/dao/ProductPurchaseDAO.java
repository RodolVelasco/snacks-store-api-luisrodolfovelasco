package com.applaudo.api.dao;

import java.util.List;

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
	
	public ProductPurchase findOne(Long productPurchaseId) {
		return productPurchaseRepository.findOne(productPurchaseId);
	}
	
	public ProductPurchase findOneByName(String name) {
		return productPurchaseRepository.findOneByProductName(name);
	}
	
	public void delete(ProductPurchase entity) {
		productPurchaseRepository.delete(entity);
	}
}
