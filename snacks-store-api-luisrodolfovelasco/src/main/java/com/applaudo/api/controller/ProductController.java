package com.applaudo.api.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.applaudo.api.dao.ProductPurchaseDAO;
import com.applaudo.api.model.Product;
import com.applaudo.api.model.ProductPurchase;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	public static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	ProductPurchaseDAO productPurchaseDAO;
	
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
	
	@PutMapping("/update/price/{id}")
	public ResponseEntity<Product> updatePriceProduct(@PathVariable(value="id") Long entityId, @Valid @RequestBody Product entityDetails) {
		
		logger.info("Modifying product {} to price: {}", entityDetails.getName(), entityDetails.getPrice());
		
		Product pro = productDAO.findOne(entityId);
		
		if(pro == null) {
			logger.error("Unable to modify the product price with name {}, product doesn't exist", entityDetails.getName());
			return ResponseEntity.notFound().build();
		}
		
		pro.setPrice(entityDetails.getPrice());
		
		Product updateProduct = productDAO.save(pro);
		
		return ResponseEntity.ok().body(updateProduct);
	}
	
	@PostMapping("/purchase")
	public ResponseEntity<ProductPurchase> purchaseProduct(@Valid @RequestBody ProductPurchase purchase/*, Principal principal*/) {
		
		Product pro = productDAO.findOneByName(purchase.getProductName());
		
		if(pro == null) {
			logger.error("Unable to find the product with name {}, product doesn't exist", purchase.getProductName());
			return ResponseEntity.notFound().build();
		}
		
		if(pro.getQuantity() < purchase.getQuantity()) {
			logger.error("Not enough stock for product name {}", purchase.getProductName());
			return ResponseEntity.unprocessableEntity().build();
		}
		
		int stock = pro.getQuantity();
		pro.setQuantity(stock-purchase.getQuantity());
		productDAO.save(pro);
		purchase.setDate(new Date());
		Principal principal = null;
		purchase.setBuyer((principal!=null) ? principal.getName() : "buyer not logged in");
		
		productPurchaseDAO.save(purchase);
		
		return ResponseEntity.ok().body(purchase);
	}
	
	@GetMapping("/purchase/list")
	public List<ProductPurchase> getAllProductsPurchase(){
		return productPurchaseDAO.findAll();
	}
}
