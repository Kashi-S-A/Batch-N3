package com.pss.pfm.dto;

import com.pss.pfm.model.TransactionType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class TransactionDTO {
	private Double amount;

	@Enumerated(EnumType.STRING)
	private TransactionType type;

	private String description;
	
	private String date;

	private String category;
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

}
