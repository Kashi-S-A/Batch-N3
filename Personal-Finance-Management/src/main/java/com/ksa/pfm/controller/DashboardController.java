package com.ksa.pfm.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ksa.pfm.repo.UserRepo;


@Controller
public class DashboardController {

	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/dashboard")
	public String dashboardPage(Principal principal,Model model) {
		String email = principal.getName();
		String name = userRepo.findByEmail(email).get().getName();
		model.addAttribute("user", name);
		return "dashboard";
	}
	
}
