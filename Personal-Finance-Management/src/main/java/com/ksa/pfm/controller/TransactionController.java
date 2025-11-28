package com.ksa.pfm.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ksa.pfm.dto.FilterTranscationDTO;
import com.ksa.pfm.dto.TransactionDTO;
import com.ksa.pfm.model.Category;
import com.ksa.pfm.model.Transaction;
import com.ksa.pfm.model.TransactionType;
import com.ksa.pfm.model.User;
import com.ksa.pfm.repo.TransactionRepo;
import com.ksa.pfm.repo.UserRepo;
import com.ksa.pfm.service.CategoryService;


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
		model.addAttribute("categories",categoryService.findByUser(user));
		List<Transaction> txns = transactionRepo.findByUser(user);
		model.addAttribute("txns", txns);
		model.addAttribute("trans",new FilterTranscationDTO());
		return "transactions";
	}
	@PostMapping("/filter-transactions")
	public String filterTransaction(Principal principal,FilterTranscationDTO trans,Model model) {
	
		User user = userRepo.findByEmail(principal.getName()).orElseThrow(()-> new UsernameNotFoundException("user not found"));
		TransactionType type = trans.getType();
		Long catId = trans.getCategory();
	    String from = (trans.getFromDate() == null) ? "" : trans.getFromDate();
	    String to = (trans.getToDate() == null) ? "" : trans.getToDate();
		List<Transaction> txns =transactionRepo.filterTrans(user.getId(), type, catId, from, to);
		model.addAttribute("txns", txns);
		model.addAttribute("categories",categoryService.findByUser(user));
		return "transactions";
	}
	
	
	@GetMapping("/update-transaction")
	public String fetcht(@RequestParam("txn") Long txn,Principal principal, Model model) {
		Transaction txnt = transactionRepo.findById(txn).orElseThrow(()->new UsernameNotFoundException("no transcation oresent"));
		model.addAttribute("txn", txnt);
		String email = principal.getName();
		User user = userRepo.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User not found"));
		model.addAttribute("categories",categoryService.findByUser(user));
		return "update-transaction";
	}
	
	@PostMapping("/update-transaction")
	public String fetcht(Model model) {
		Transaction transcation = (Transaction) model.getAttribute("txn");
		return "update-transaction";
	}
}
