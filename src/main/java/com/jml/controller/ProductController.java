package com.jml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jml.dao.ProductDao;
import com.jml.model.Product;
import com.jml.service.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private ProductDao productDao;

	@GetMapping
	public List<Product> listProduct() {
		return productService.getAllProducts();
	}

	@PostMapping
	public Product saveProduct(@RequestBody Product newProd) {
		return productDao.save(newProd);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable(value = "id") Integer id, @RequestBody Product productDetail) {
		if (productService.findProduct(id) == null) {
			return null;
		} else {
			return productService.updateProduct(productDetail.getProductCode(),
					productDetail.getProductName(),
					productDetail.getProductDesc(),
					productDetail.getProductPrice(), 
					productDetail.getProductAge());
		}

	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable int id) {
		return productService.findProduct(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok().build();
	}
}
