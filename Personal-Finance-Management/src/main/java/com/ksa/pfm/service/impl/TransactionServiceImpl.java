package com.ksa.pfm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksa.pfm.model.Transaction;
import com.ksa.pfm.repo.TransactionRepo;
import com.ksa.pfm.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
    
	@Autowired
	private TransactionRepo transactionRepo;

	@Override
	public void deleteById(Long id) {
		transactionRepo.deleteById(id);
	}

	@Override
	public Transaction findById(Long id) {
		return transactionRepo.findById(id).orElseThrow(()-> new RuntimeException("ID not Found"));
	}

	@Override
	public Transaction update(Transaction txn) {		
		return transactionRepo.save(txn);
		
	}

}
