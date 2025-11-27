package com.ksa.pfm.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ksa.pfm.model.Category;
import com.ksa.pfm.model.TransactionType;
import com.ksa.pfm.model.User;
import com.ksa.pfm.repo.UserRepo;
import com.ksa.pfm.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/category")
	public String categorypage(Principal principal, Model model) {
		User user = userRepo.findByEmail(principal.getName())
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

		model.addAttribute("categories", categoryService.findByUser(user));

		return "category";
	}

	@PostMapping("/category")
	public String postCategory(Principal principal, @RequestParam String catName, @RequestParam TransactionType type,
			Model model) {
		User user = userRepo.findByEmail(principal.getName())
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

		Category category = new Category();
		category.setName(catName);
		category.setType(type);

		category.setUser(user);
		categoryService.saveCategory(category);

		return "redirect:/category";
	}
}
