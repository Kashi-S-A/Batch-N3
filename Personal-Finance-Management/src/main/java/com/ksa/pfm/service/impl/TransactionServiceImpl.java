package com.ksa.pfm.service.impl;

import com.ksa.pfm.service.TransactionService;

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
