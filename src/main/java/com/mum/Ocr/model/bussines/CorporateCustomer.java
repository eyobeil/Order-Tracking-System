package com.mum.Ocr.model.bussines;

import com.mum.Ocr.model.Customer;

public class CorporateCustomer extends Customer{

	private double creditLimit;
	private String rating;

	
	

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

//	public double billForMonth() {
//		double sum = 0;
//		List<Order> orders = super.getOrders();
//		for (Order o : orders) {
//			sum += o.calculateTotalPrice();
//		}
//		return sum;
//	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	

}
