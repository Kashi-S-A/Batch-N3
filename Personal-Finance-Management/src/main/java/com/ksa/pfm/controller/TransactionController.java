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
	
	
	// To delete the transaction
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
	    transactionService.deleteById(id);
	    return "redirect:/transactions";
	}
	
	// to view the add-transaction page to perform update
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
	    Transaction txn = transactionService.findById(id);
        
	    List<Category> categories = categoryService.findAll();
	    model.addAttribute("transaction",txn);
	    model.addAttribute("categories", categories);
	    return "edit-transaction"; 
	}
	
	//to edit the transaction
	 @PostMapping("/edit/{id}")
	    public String updateTransaction(@PathVariable Long id, @ModelAttribute TransactionDTO transactionDTO) {
	        Transaction txn = transactionService.findById(id);

	        txn.setAmount(transactionDTO.getAmount());
	        txn.setDescription(transactionDTO.getDescription());
	        txn.setDate(transactionDTO.getDate());
	        txn.setType(transactionDTO.getType());
	        txn.setCategory(categoryService.findByName(transactionDTO.getCategory()));

	        transactionService.update(txn);

	        return "redirect:/transactions";
	
	 }
}
