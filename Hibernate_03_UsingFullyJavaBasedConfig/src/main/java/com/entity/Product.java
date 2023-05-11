package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productid")
	private int productid;
	@Column(name = "productName")
	private String productName;
	@Column(name = "productdescription")
	private String productdescription;
	
	
	public Product() {
	}
	
	public Product(int productid, String productName, String productdescription) {
		super();
		this.productid=productid;
		this.productName = productName;
		this.productdescription = productdescription;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	
	@Override
	public String toString() {
		return "Product [ productName=" + productName + ", productdescription=" + productdescription +"]";
	}
	
	

}
