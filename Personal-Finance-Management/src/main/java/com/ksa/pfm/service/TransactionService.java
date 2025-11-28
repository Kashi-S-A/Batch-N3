package com.ksa.pfm.service;

public interface TransactionService {
    public void deleteById(Long id);
	
	public Transaction findById(Long id);

<<<<<<< HEAD
=======
    public void deleteById(Long id);
	
	public Transaction findById(Long id);

>>>>>>> 6c198e0cd0e5cb92a8ffdcb0b54d459ad2d5afac
	public Transaction update(Transaction txn);
}
