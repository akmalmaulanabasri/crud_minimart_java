package com.minimart.domain;

public class OrderItem {
	String orderId;
	String code;
	String name;
	String type;
	double price;
	Integer quantity;
	double totalPrice;

	public OrderItem(String orderId, String code, String name, String type, double price, Integer quantity, double totalPrice) {
		this.orderId = orderId;
		this.code = code;
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	
	public String getOrderId() {
		return orderId;
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

	public Integer getQuantity() {
		return quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}


	
	
}
