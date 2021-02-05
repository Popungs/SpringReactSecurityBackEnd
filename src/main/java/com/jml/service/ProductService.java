package com.jml.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jml.dao.ProductDao;
import com.jml.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	public boolean createProduct(String productCode, String productName, String productDesc, Double productPrice,
			int productAge) {
		Product newProduct = new Product();
		newProduct.setProductCode(productCode); // this will be uniquecode

		Optional<Product> p = this.getAllProducts().stream().filter(e -> e.getProductCode().equals(productCode))
				.findAny();
		if (p.isPresent()) {
			return false;
		} else {

			newProduct.setProductName(productName);
			newProduct.setProductDesc(productDesc);
			newProduct.setProductPrice(productPrice);
			newProduct.setProductAge(productAge);
			productDao.save(newProduct);
			return true;
		}
	}
	public Product findProduct(int targetId) {
		Optional<Product> p = productDao.findById(targetId);
		if (p.isPresent()) {
			return p.get();
		} else {
			return null;
		}
	}
	
	public Product updateProduct(String productCode, String productName, 
			String productDesc, Double productPrice,
			int productAge) {
		// it shouldnt take different productCode
		Optional<Product> p = this.getAllProducts().stream().filter(e -> e.getProductCode().equals(productCode))
				.findAny();
		if (p.isPresent()) {
			Product target = p.get();
			target.setProductAge(productAge);
			target.setProductDesc(productDesc);
			target.setProductName(productName);
			target.setProductPrice(productPrice);
			target.setProductAge(productAge);
			return productDao.save(target);
		} else {
			return null;
		}
	}
	
	public boolean deleteProduct(int targetId) {
		Optional<Product> p = productDao.findById(targetId);
		if (p.isPresent()) {
			productDao.deleteById(targetId);
			return true;
		} else {
			return false;
		}
	}
}
