package com.tyss.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductDTO {

	@Size(min = 3, max = 25, message = "Product Name should be between 3 to 25 characters")
	private String name;

	private Double price;

	@NotBlank(message = "description should not be blank")
	private String description;

	private Integer units;

	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", price=" + price + ", description=" + description + ", units=" + units
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUnits() {
		return units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

}
