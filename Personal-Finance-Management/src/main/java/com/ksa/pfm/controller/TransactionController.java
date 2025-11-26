package com.ksa.pfm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionController {

	@GetMapping("/add-transaction")
	public String addtransactionpage()
	{
		return "add-transaction";
	}
}
