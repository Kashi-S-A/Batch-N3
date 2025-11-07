package com.tyss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.dao.ProductDAO;
import com.tyss.dto.ProductDTO;
import com.tyss.model.Product;
import com.tyss.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductDAO productDAO;

	@Override
	public String save(ProductDTO productDTO) {
		Product product = new Product();
		BeanUtils.copyProperties(productDTO, product);
		Product savedProduct = productRepository.save(product);
		return "Product with Id : " + savedProduct.getPid();
	}

	@Override
	public Product findById(Integer pid) {
		Optional<Product> opt = productRepository.findById(pid);

//		if (opt.isPresent()) {
//			return opt.get();
//		}

		Product product = opt.orElseThrow(() -> new RuntimeException("Product not found"));
		return product;
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public String deleteById(Integer pid) {
		productRepository.deleteById(pid);
		return "Deleted Successfully";
	}

	@Override
	public String updateProduct(Integer pid, ProductDTO ProductDto) {
		return productDAO.updateProduct(pid, ProductDto);
	}

	@Override
	public String updatePrice(Integer pid, Double price) {
		return productDAO.updatePrice(pid, price);
		;
	}

}
