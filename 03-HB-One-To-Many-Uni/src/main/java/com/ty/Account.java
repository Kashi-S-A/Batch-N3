package com.ty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	private int accno;
	private String name;
	private double balance;

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
