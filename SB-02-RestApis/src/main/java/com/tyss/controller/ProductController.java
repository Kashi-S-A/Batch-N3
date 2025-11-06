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
	public Product getProduct(@RequestParam(name = "id") int pid) {
		System.out.println(pid);
		for (Product product : products) {
			if (product.getPid() == pid)
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

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int pid) {
		System.out.println(pid);
		for (Product product : products) {
			if (product.getPid() == pid) {
				products.remove(product);
				return "Product with id : " + pid + " is Deleted";
			}
		}
		return "Product Not found";
	}

	@PutMapping("/update")
	public String updateProduct(@RequestParam int pid, @RequestBody Product prod) {
		for (Product product : products) {
			if (product.getPid() == pid) {
				products.remove(product);
				if(prod.getName()!=null) product.setName(prod.getName());
				if(prod.getDescription()!=null) product.setDescription(prod.getDescription());
				if(prod.getPrice()>0)product.setPrice(prod.getPrice());
				if(prod.getUnits()>0)product.setUnits(prod.getUnits());
				products.add(product);
				return "Product is updated";
			}
		}
		return "Product Not found";
	}

	@GetMapping("/head")
	public String getHeaddata(@RequestHeader String token) {
		System.out.println(token);
		return "token recieved";
	}

}
