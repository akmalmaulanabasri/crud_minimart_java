package com.minimart.domain;

public class Product {
	String code;
	String name;
	String type;
	double price;
	
	public Product(String code, String name, String type, double price) {
		this.code = code;
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}
	
	
}
