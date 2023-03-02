package com.minimart.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
	String orderNumber;
	String orderDate;
	double totalPrice;
	
	public String getOrderNumber() {
		return orderNumber;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public Order(String orderNumber) {
		this.orderNumber = orderNumber;
		this.orderDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public Order(String orderNumber, String orderDate, double totalPrice) {
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
	}
}
