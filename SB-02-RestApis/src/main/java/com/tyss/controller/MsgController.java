package com.tyss.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {

	@GetMapping("/fetch")
	public String getMsg() {
		System.out.println("get request");
		return "Fetched";
	}
	
	@PostMapping("/fetch")
	public String get() {
		System.out.println("get request");
		return "Fetched";
	}

	@PostMapping("/save")
	public String demo() {
		System.out.println("post request");
		return "Saved";
	}

	@PutMapping("/update")
	public String putMethodName() {
		return "Updated";
	}

	@DeleteMapping("/delete")
	public String delete() {
		return "Deleted";
	}

	@PatchMapping("/upd")
	public String update() {
		return "Updated";
	}
}
