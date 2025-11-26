package com.ksa.pfm.dto;

import lombok.Data;

@Data
public class BudgetDTO {

	private Integer month;
	private Integer year;
	private Double amount;
	private String catName;

}
