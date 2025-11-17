package com.tyss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/msg")
	public String getMessage() {
		return "Hi How are you ?";
	}

	@GetMapping("/greet")
	public String greet() {
		return "Welcome to spring security";
	}

	@GetMapping("/admin")
	public String sayHi() {
		return "Welcome Admin";
	}
	
	@GetMapping("/admin/hi")
	public String hello() {
		return "Hi from Admin";
	}

}
