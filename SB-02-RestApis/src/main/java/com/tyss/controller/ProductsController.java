package com.tyss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pd")
public class ProductsController {

	@Autowired
	private ProductService productService;
	
	// save
	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@RequestBody @Valid ProductDTO productDTO) {
		return productService.save(productDTO);
	}

	// fetchById
	@GetMapping("/byId")
	public ResponseEntity<?> productById(@RequestParam Integer pid) {
		return productService.findById(pid);
	}

	// fetchAll
	@GetMapping
	public List<Product> getAllProduct(@RequestParam Integer page) {
		return productService.findAll(page);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Product>> getByNameContaining(@RequestParam String name) {
		return productService.getByNameContaining(name);
	}

	// sorting
	@GetMapping("/sort")
	public List<Product> sortProducts(@RequestParam String property, @RequestParam String order) {
		return productService.sortProducts(property, order);
	}

	// filter
	@GetMapping("/filter")
	public List<Product> filterProducts(@RequestBody ProductDTO productDTO) {
		return productService.filterProducts(productDTO);
	}

	// deleteById
	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer pid) {
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

	@GetMapping(value = "/content",produces = {
												"application/xml",
												"application/json"
											   },
								   consumes = {
										   		"application/xml",
										   		"application/json"
				   							  }
	)
	public ProductDTO getMethodName(@RequestBody ProductDTO productDTO) {
		System.out.println("========Product Recieved=========");
		System.out.println(productDTO);
		System.out.println("========Product Sent=========");
		return productDTO;
	}
	
	@GetMapping("/exc")
	public String exception() {
		System.out.println("==========Started============");
//		String st="Hi";
//		System.out.println(st.charAt(10));
//		String s = null;
//		System.out.println(s.charAt(0));
		int a = 10/0;
		System.out.println("==========ended============");
		return "This is Exception Handling API";
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> catchException() {
		System.out.println("AE Exception handled");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("exception is handled");
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> catchNullPointerException(NullPointerException e) {
		System.out.println("Hanlde NPE");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> catchException(Exception e) {
		System.out.println("handle all exception");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

}
