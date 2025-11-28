package com.ksa.pfm.dto;

import com.ksa.pfm.model.TransactionType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class FilterTranscationDTO {
	private Long category;
	
	@Enumerated(EnumType.STRING)
	private TransactionType type;

	private String fromDate;
	private String toDate;
	
	public Long getCategory() {
		return category;
	}
	public void setCategory(Long category) {
		this.category = category;
	}
	public TransactionType getType() {
		return type;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
}
