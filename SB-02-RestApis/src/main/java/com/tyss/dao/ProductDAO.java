package com.tyss.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.dto.ProductDTO;
import com.tyss.model.Product;
import com.tyss.repository.ProductRepository;

@Repository
public class ProductDAO {

	@Autowired
	private ProductRepository productRepository;

	/*
	 * fetch product by id update price and save product
	 */
	public String updatePrice(Integer pid, Double price) {
		Optional<Product> opt = productRepository.findById(pid);
		if (opt.isPresent()) {
			Product product = opt.get();
			product.setPrice(price);
			productRepository.save(product);
			return "product with id : " + product.getPid() + " is update, price " + price;
		} else {
			return "Product with id : " + pid + " is not found";
		}

//		Product product = productRepository.findById(pid)
//				.orElseThrow(() -> new RuntimeException("Product Not found pid : " + pid));
//		product.setPrice(price);
//		productRepository.save(product);
//		return "Updated Successfully";
	}

	/*
	 * fetch product by id update the product new data present in dto and save
	 * product
	 */
	public void updateProduct(Integer pid, ProductDTO dto) {
	}
}
