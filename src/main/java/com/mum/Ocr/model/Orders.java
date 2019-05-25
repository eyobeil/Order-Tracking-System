package com.mum.Ocr.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Orders  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long orderId;
	private LocalDate dateOfOrder; 
	@OneToMany(mappedBy = "orders",cascade = CascadeType.PERSIST)
	private List<OrderLine> orderLines=new ArrayList<>();
	 @ManyToOne(cascade = CascadeType.PERSIST)
	 @JoinColumn(name = "fk_customer")
	private Customer customer;
		
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(LocalDate dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
