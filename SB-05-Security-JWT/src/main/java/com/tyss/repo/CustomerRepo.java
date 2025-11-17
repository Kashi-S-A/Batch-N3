package com.tyss.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	public Optional<Customer> findByEmail(String email);
}
