package com.ksa.pfm.dto;

import com.ksa.pfm.model.TransactionType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class TransactionDTO {

	private Double amount;

	@Enumerated(EnumType.STRING)
	private TransactionType type;

	private String date;
	private String category;
	private String description;

}
