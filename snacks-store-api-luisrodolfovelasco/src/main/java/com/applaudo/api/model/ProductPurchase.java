package com.applaudo.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="products_purchase")
@EntityListeners(AuditingEntityListener.class)
public class ProductPurchase implements Serializable {
	
	private static final long serialVersionUID = 3840556800021614915L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String productName;
	private String buyer;
	private Integer quantity;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date date;
	
	public ProductPurchase() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ProductPurchase [id=" + id + ", productName=" + productName + ", buyer=" + buyer + ", quantity="
				+ quantity + ", date=" + date + "]";
	}
	
	
	
}
