package com.ksa.pfm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ksa.pfm.model.Transaction;
import com.ksa.pfm.model.User;


public interface TransactionRepo extends JpaRepository<Transaction, Long> {

	List<Transaction> findByUser(User user);
}
