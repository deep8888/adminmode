package com.poi.model;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Product {
	private int id;
	
	@NotEmpty(message="The product name must not be null")
	private String name;
	
	private String category;
	
	@Min(value=0, message="The product price must not be less than zero")
	private int price;
	
	@NotEmpty(message="The product manufacturer must not be null")
	private String manufacturer;
	
	@Min(value=0, message="The product unitInStock must not be less than zero")
	private int unitInStock;
	//DB내에서null이여도 상관없다고 정함
	private String description;
}