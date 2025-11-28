package com.ksa.pfm.controller;

import java.security.Principal;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ksa.pfm.dto.TransactionDTO;
import com.ksa.pfm.model.User;

@Controller
public class ReportController {

	@GetMapping("/report")
	public String getMethodName() {
		return "report";
	}
}
