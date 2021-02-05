package com.jml.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jml.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

}
