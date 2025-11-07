package com.tyss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.service.ProductService;

@RestController
@RequestMapping("/pd")
public class ProductsController {

	@Autowired
	private ProductService productService;
}
