package com.tyss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.dto.ProductDTO;
import com.tyss.model.Product;
import com.tyss.service.ProductService;

@RestController
@RequestMapping("/pd")
public class ProductsController {

	@Autowired
	private ProductService productService;

	// save
	@PostMapping("/save")
	public String saveProduct(@RequestBody ProductDTO productDTO) {
		return productService.save(productDTO);
	}

	// fetchById
	@GetMapping("/byId")
	public Product productById(@RequestParam Integer pid) {
		return productService.findById(pid);
	}

	// fetchAll
	@GetMapping
	public List<Product> getAllProduct(@RequestParam Integer page) {
		return productService.findAll(page);
	}

	// sorting
	@GetMapping("/sort")
	public List<Product> sortProducts(@RequestParam String property, @RequestParam String order) {
		return productService.sortProducts(property, order);
	}

	// filter
	@GetMapping("/filter")
	public List<Product> filterProducts(@RequestBody ProductDTO productDTO) {
		System.out.println(productService.filterProducts(productDTO));
		return productService.filterProducts(productDTO);
	}

	// deleteById
	@DeleteMapping("/delete/{pid}")
	public String deleteProduct(@PathVariable Integer pid) {
		return productService.deleteById(pid);
	}

	// updatePrice
	@PutMapping("/update/{pid}")
	public String updatePrice(@PathVariable Integer pid, @RequestParam Double price) {
		return productService.updatePrice(pid, price);
	}

	// updateProduct
	@PutMapping("/upd/{pid}")
	public String updateProduct(@PathVariable Integer pid, @RequestBody ProductDTO productDTO) {
		return productService.updateProduct(pid, productDTO);
	}
}
