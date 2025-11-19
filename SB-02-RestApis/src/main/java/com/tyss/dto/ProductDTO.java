package com.tyss.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {

//	@Size(min = 3, max = 25, message = "Product Name should be between 3 to 25 characters")
	private String name;

	private Double price;

	@NotBlank(message = "description should not be blank")
	private String description;

	private Integer units;

}
