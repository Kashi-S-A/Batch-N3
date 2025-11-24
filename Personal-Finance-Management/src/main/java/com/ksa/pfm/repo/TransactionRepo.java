package com.ksa.pfm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ksa.pfm.model.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

}
