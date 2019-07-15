package com.applaudo.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

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
	
	public Product findOneByName(String name) {
		return productRepository.findOneByName(name);
	}
	
	public void delete(Product entity) {
		productRepository.delete(entity);
	}
	
	public List<Product> findAllWithPagination(String orderBy, String sorting, int page, int size)
	{
		Sort sort = null;
		
		if (sorting.equals("asc")) {
			sort = new Sort(new Sort.Order(Direction.ASC, orderBy));
		}
		if (sorting.equals("desc")) 
		{
			sort = new Sort(new Sort.Order(Direction.DESC, orderBy));
		}
		Pageable pageable = new PageRequest(page, size, sort);
		
		Page<Product> data = productRepository.findAll(pageable);
		return data.getContent();
		
	}
	
}
