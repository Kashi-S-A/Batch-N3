package com.tyss.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tyss.dto.ProductDTO;
import com.tyss.model.Product;

public interface ProductService {

	ResponseEntity<String> save(ProductDTO productDTO);

	ResponseEntity<?> findById(Integer pid);

	List<Product> findAll(Integer page);

	ResponseEntity<String> deleteById(Integer pid);

	String updateProduct(Integer pid, ProductDTO ProductDto);

	String updatePrice(Integer pid, Double price);

	List<Product> sortProducts(String property, String order);

	List<Product> filterProducts(ProductDTO productDTO);

	ResponseEntity<List<Product>> getByNameContaining(String name);

}
