package com.tyss.service;

import java.util.List;

import com.tyss.dto.ProductDTO;
import com.tyss.model.Product;

public interface ProductService {

	String save(ProductDTO productDTO);

	Product findById(Integer pid);

	List<Product> findAll();

	String deleteById(Integer pid);

	String updateProduct(Integer pid, ProductDTO ProductDto);

	String updatePrice(Integer pid, Double price);

}
