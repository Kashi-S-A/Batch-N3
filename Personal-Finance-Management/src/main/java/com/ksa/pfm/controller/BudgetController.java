package com.ksa.pfm.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ksa.pfm.dto.BudgetDTO;
import com.ksa.pfm.model.Budget;
import com.ksa.pfm.model.Category;
import com.ksa.pfm.model.User;
import com.ksa.pfm.repo.BudgetRepo;
import com.ksa.pfm.repo.UserRepo;
import com.ksa.pfm.service.CategoryService;

@Controller
public class BudgetController {

	@Autowired
	private BudgetRepo budgetRepo;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private UserRepo userRepo;

	// Budget View Page
	@GetMapping("/budget")
	public String budgetPage(Principal principal, Model model,@RequestParam(required = false) String msg) {
		User user = userRepo.findByEmail(principal.getName())
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
		model.addAttribute("budgetDTO", new BudgetDTO());//form biding
		model.addAttribute("categories", categoryService.findByUser(user));//to display categories in add budget page
		model.addAttribute("budgets", budgetRepo.findByUser(user));//display existing budgets
		model.addAttribute("msg", msg);
		return "budget";
	}

	// Add Budget
	@PostMapping("/budget")
	public String postBudget(Principal principal, BudgetDTO budgetDTO) {

		Budget budget = new Budget();
		BeanUtils.copyProperties(budgetDTO, budget);

		User user = userRepo.findByEmail(principal.getName())
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
		budget.setUser(user);

		String catName = budgetDTO.getCatName();
		
		Category savedCategory = categoryService.findByName(catName);
		
		if (savedCategory!=null) {
			budget.setCategory(savedCategory);
		} else {
			Category category = new Category();
			category.setName(catName);
			category.setUser(user);
			Category saveCategory = categoryService.saveCategory(category);
			budget.setCategory(saveCategory);
		}

		budgetRepo.save(budget);
		return "redirect:/budget?msg=Budget Added";
	}

}
