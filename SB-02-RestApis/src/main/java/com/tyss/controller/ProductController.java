package com.tyss.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final List<Product> products = new ArrayList<>();

	@GetMapping("/")
	public List<Product> getProducts() {
		return products;
	}

	@GetMapping("/fetch")
	public Product getProduct(@RequestParam(name = "id") int pid, @RequestParam String name) {
		System.out.println(pid);
		System.out.println(name);
		for (Product product : products) {
			if (product.getPid() == pid && product.getName().equals(name))
				return product;
		}
		return null;
	}

	@PostMapping("/save")
	public String saveProduct(@RequestBody Product product) {
		System.out.println(product);
		products.add(product);
		return "Product is saved with pid : " + product.getPid();
	}

	@DeleteMapping("/delete/{id}/dp/name/{pname}")
	public String deleteProduct(@PathVariable(name = "id") int pid,@PathVariable String pname) {
		System.out.println(pname);
		System.out.println(pid);
		return "Product with id : " + pid + " is Deleted";
	}

	@PutMapping("/update")
	public String updateProduct() {
		return "Product Updated";
	}

	@GetMapping("/head")
	public String getHeaddata(@RequestHeader String token) {
		System.out.println(token);
		return "token recieved";
	}
	
}
