package com.ksa.pfm.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ksa.pfm.model.Transaction;
import com.ksa.pfm.model.TransactionType;
import com.ksa.pfm.model.User;
import com.ksa.pfm.repo.TransactionRepo;
import com.ksa.pfm.repo.UserRepo;


@Controller
public class DashboardController {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private TransactionRepo transRepo;
	
	@GetMapping("/dashboard")
	public String dashboardPage(Principal principal,Model model) {
		String email = principal.getName();
		String name = userRepo.findByEmail(email).get().getName();
		model.addAttribute("user", name);
		return "dashboard";
	}
	
	@ResponseBody
	@GetMapping("/api/chart/categorywise")
	public Map<String, Double> categoryChart(Principal principal) {
		String email = principal.getName();
		User user = userRepo.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("user not found"));
		String endDate = LocalDate.now()+"";
		String startDate = LocalDate.now().withDayOfMonth(1)+"";
		
		List<Transaction> transcation = transRepo.findByUserAndDateBetween(user,startDate,endDate);
		
		Map<String,Double> map = new HashMap<>();
		for(Transaction trans : transcation) {	
			if (map.containsKey(trans.getCategory().getName())) {
			    map.put(trans.getCategory().getName(), map.get(trans.getCategory().getName()) + trans.getAmount());
			} else {
			    map.put(trans.getCategory().getName(), trans.getAmount());
			}
		}		
		return map;
	}
	
	@ResponseBody
	@GetMapping("/api/chart/income-expense")
	public Map<String, Double> incomeExpenseChart(Principal principal) {
		String email = principal.getName();
		User user = userRepo.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("user not found"));
		
		String endDate = LocalDate.now()+"";
		String startDate = LocalDate.now().withDayOfMonth(1)+"";
		
		List<Transaction> transcation = transRepo.findByUserAndDateBetween(user,startDate,endDate);
		
		Map<String,Double> map = new HashMap<>();
		Double incomeAmount = 0.0;
		Double expenseAmount = 0.0;

		for(Transaction trans : transcation) {	
			if(trans.getType().equals(TransactionType.INCOME)) {
				incomeAmount = incomeAmount + trans.getAmount();
			}
			else {
				expenseAmount = expenseAmount + trans.getAmount();
			}
		}
		map.put(TransactionType.INCOME+"", incomeAmount);
		map.put(TransactionType.EXPENSE+"", expenseAmount);
		return map;
	}
	
	@ResponseBody
	@GetMapping("/api/chart/daywise")
	public Map<String, Double> dayChart(Principal principal) {
		String email = principal.getName();
		User user = userRepo.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("user not found"));
		
		String endDate = LocalDate.now()+"";
		String startDate = LocalDate.now().withDayOfMonth(1)+"";
		
		List<Transaction> transcation = transRepo.findByUserAndTypeAndDateBetween(user,TransactionType.EXPENSE,startDate,endDate);
		
		Map<String,Double> map = new HashMap<>();
		for(Transaction trans : transcation) {	
			if (map.containsKey(trans.getDate())) {
			    map.put(trans.getDate(),map.get(trans.getDate()) +trans.getAmount());
			} else {
			    map.put(trans.getDate(),trans.getAmount());
			}
		}		
		return map;
	}
	
}
