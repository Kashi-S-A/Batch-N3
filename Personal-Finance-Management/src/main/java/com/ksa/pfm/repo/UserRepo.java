package com.ksa.pfm.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ksa.pfm.model.User;


public interface UserRepo extends JpaRepository<User, Long> {

	public Optional<User> findByEmail(String email);
}
