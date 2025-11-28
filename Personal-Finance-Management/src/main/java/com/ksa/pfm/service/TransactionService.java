package com.ksa.pfm.service;

public interface TransactionService {

    public void deleteById(Long id);
	
	public Transaction findById(Long id);

	public Transaction update(Transaction txn);
}
