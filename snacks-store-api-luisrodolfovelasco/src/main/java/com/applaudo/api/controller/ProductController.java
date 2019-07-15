package com.applaudo.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.applaudo.api.dao.ProductDAO;
import com.applaudo.api.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductDAO productDAO;
	
	@PostMapping("/create")
	public Product createProduct(@Valid @RequestBody Product entity) {
		return productDAO.save(entity);
	}
	
	@GetMapping("/list")
	public List<Product> getAllProducts(){
		return productDAO.findAll();
	}
	
	@GetMapping("/show/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value="id") Long entityId){
		Product pro = productDAO.findOne(entityId);
		
		if(pro == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(pro);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value="id") Long entityId, @Valid @RequestBody Product entityDetails) {
		
		Product pro = productDAO.findOne(entityId);
		
		if(pro == null)
			return ResponseEntity.notFound().build();
		
		pro.setName(entityDetails.getName());
		pro.setLikes(entityDetails.getLikes());
		pro.setPrice(entityDetails.getPrice());
		pro.setQuantity(entityDetails.getQuantity());
		
		Product updateProduct = productDAO.save(pro);
		
		return ResponseEntity.ok().body(updateProduct);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable(value="id") Long entityId) {
		Product pro = productDAO.findOne(entityId);
		
		if(pro == null)
			return ResponseEntity.notFound().build();
		
		productDAO.delete(pro);
		
		return ResponseEntity.ok().build();
	}
}
