package com.mum.Ocr.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.mum.Ocr.model.bussines.CreditRating;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	private String firstName;
	private String email;
	private String address;
	private String contactPhoneNumber;
	private double points;
	@Enumerated(EnumType.STRING)
	private CreditRating rate;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
	private List<Orders> orders = new ArrayList<>();

	public Customer() {

	}

	public Customer(String firstName, String email, String address, String contactPhoneNumber, double points,
			CreditRating rate, List<Orders> orders) {

		this.firstName = firstName;
		this.email = email;
		this.address = address;
		this.contactPhoneNumber = contactPhoneNumber;
		this.points = points;
		this.rate = rate;
		this.orders = orders;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public void addOrders(Orders order) {
		orders.add(order);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public CreditRating getRate() {
		return rate;
	}

	public void setRate(CreditRating rate) {
		this.rate = rate;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void addOrder(Orders orders) {
		this.orders.add(orders);
	}

}
