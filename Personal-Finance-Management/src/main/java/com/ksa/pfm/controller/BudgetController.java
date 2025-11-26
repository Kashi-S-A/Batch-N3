package com.ksa.pfm.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ksa.pfm.dto.BudgetDTO;
import com.ksa.pfm.dto.RegisterDTO;
import com.ksa.pfm.model.Budget;
import com.ksa.pfm.repo.BudgetRepo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BudgetController {
	
	@Autowired
	private BudgetRepo budgetRepo;
		
	//Budget View Page
	@GetMapping("/budget")
	public String getMethodName(Model model) {
		model.addAttribute("dto", new BudgetDTO());
		return "budget";
	}
	
	// Add Budget 
	@PostMapping("/budget")
	public String postBudget(BudgetDTO dto) {
		//TODO: process POST request
		Budget budget=new Budget();
		BeanUtils.copyProperties(dto, budget);
		budgetRepo.save(budget);
		return "/budget";
	}
	

}
