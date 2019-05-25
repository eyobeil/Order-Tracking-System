package com.mum.Ocr.model;

import javax.persistence.*;

@Entity
public class OrderLine{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long orderLineId;
	private int quantity;
	@OneToOne(cascade = CascadeType.MERGE)
	//@JoinColumn(nullable=true)
	 //@JoinColumn(name = "product")
	private Product product;
	@ManyToOne(cascade = CascadeType.PERSIST)
	 @JoinColumn(name = "fk_orders")
	private Orders orders;

	
	public long getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(long orderLineId) {
		this.orderLineId = orderLineId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	

	

	
	
	

}
