package com.ksa.pfm.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ForgotPassword {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fgid;
	
	@Column(nullable = false)
	private Integer otp;
	
	@Column(nullable=false)
	private Date expirrationTime;
	
	@OneToOne
	@JoinColumn(name ="u_id")
	private User user;

	

	public ForgotPassword() {
	}

	public ForgotPassword( Integer otp, Date expirrationTime, User user) {
		this.otp = otp;
		this.expirrationTime = expirrationTime;
		this.user = user;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public Date getExpirrationTime() {
		return expirrationTime;
	}

	public void setExpirrationTime(Date expirrationTime) {
		this.expirrationTime = expirrationTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getFgid() {
		return fgid;
	}
	
	

}