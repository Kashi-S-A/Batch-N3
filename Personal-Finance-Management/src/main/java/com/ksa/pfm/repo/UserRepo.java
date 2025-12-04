package com.ksa.pfm.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ksa.pfm.model.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	public Optional<User> findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.password = :password WHERE u.email = :email")
	void updatePassword(@Param("email") String email, @Param("password") String password);

}
