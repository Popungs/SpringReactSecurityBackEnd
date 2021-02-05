package com.jml.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="product_db")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String productCode;
	private String productName;
	private String productDesc;
	private Double productPrice;
	private int productAge; // idk
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String productCode, String productName, String productDesc, Double productPrice, int productAge) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.productAge = productAge;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductAge() {
		return productAge;
	}
	public void setProductAge(int productAge) {
		this.productAge = productAge;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productCode=" + productCode + ", productName=" + productName + ", productDesc="
				+ productDesc + ", productPrice=" + productPrice + ", productAge=" + productAge + "]";
	}
	
	
	
}
