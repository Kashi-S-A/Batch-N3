package com.ksa.pfm.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ksa.pfm.dto.TransactionDTO;
import com.ksa.pfm.model.Category;
import com.ksa.pfm.model.Transaction;
import com.ksa.pfm.model.User;
import com.ksa.pfm.repo.TransactionRepo;
import com.ksa.pfm.repo.UserRepo;
import com.ksa.pfm.service.CategoryService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TransactionController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private TransactionRepo transactionRepo;

	@GetMapping("/add-transaction")
	public String addTransactionPage(Principal principal, Model model) {
		model.addAttribute("txn", new TransactionDTO());

		User user = userRepo.findByEmail(principal.getName())
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

		model.addAttribute("categories", categoryService.findByUser(user));

		return "add-transaction";
	}

	@PostMapping("/add-transaction")
	public String saveTransaction(Principal principal, TransactionDTO txn) {

		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(txn, transaction);

		User user = userRepo.findByEmail(principal.getName())
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

		transaction.setUser(user);

		Category category = categoryService.findByName(txn.getCategory());

		transaction.setCategory(category);

		transactionRepo.save(transaction);

		return "redirect:/add-transaction";
	}
	
	@GetMapping("/transactions")
	public String fetchAllTransaction(Principal principal,Model model) {
		String email = principal.getName();
		User user = userRepo.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User not found"));
		List<Transaction> txns = transactionRepo.findByUser(user);
		model.addAttribute("txns", txns);
		return "transactions";
	}
	

}
