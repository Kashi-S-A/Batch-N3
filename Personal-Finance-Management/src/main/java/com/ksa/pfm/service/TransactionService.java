package com.ksa.pfm.service;

import com.ksa.pfm.model.Transaction;

public interface TransactionService {

	public void deleteById(Long id);

	public Transaction findById(Long id);

	public Transaction update(Transaction txn);
}
