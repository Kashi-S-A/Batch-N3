package com.ty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BankAccount {

	private String bankName;

	private String ifsc;

	public void deposit() {
		System.out.println("Used to deposit money to the given account");
	}

	@Value("SBI")
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Value("SBIN112233")
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public void displayBank() {
		System.out.println("Bank Name : " + bankName);
		System.out.println("Bank IFSC : " + ifsc);
	}

}
