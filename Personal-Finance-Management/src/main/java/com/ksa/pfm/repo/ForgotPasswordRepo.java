package com.ksa.pfm.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ksa.pfm.model.ForgotPassword;
import com.ksa.pfm.model.User;
@Repository
public interface ForgotPasswordRepo extends JpaRepository<ForgotPassword, Integer> {
	@Query("SELECT fd FROM ForgotPassword fd WHERE fd.otp = ?1 AND fd.user = ?2")
	Optional<ForgotPassword> findByOtpAndUser(Integer otp, User user);
	
	Optional<ForgotPassword> findByUser(User user);
	
	int deleteByExpirrationTimeBefore(Date now);

	List<ForgotPassword> findByExpirrationTimeBefore(Date date);



}
