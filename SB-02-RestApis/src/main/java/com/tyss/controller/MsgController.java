package com.tyss.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msg")
public class MsgController {

	@GetMapping
	public String getMsg() {
		System.out.println("get request");
		return "Fetched";
	}
	
	@PostMapping
	public String demo() {
		System.out.println("post request");
		return "Saved";
	}

	@PutMapping
	public String putMethodName() {
		return "Updated";
	}

	@DeleteMapping
	public String delete() {
		return "Deleted";
	}

	@PatchMapping
	public String update() {
		return "Updated";
	}
}
