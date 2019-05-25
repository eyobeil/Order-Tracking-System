package com.mum.Ocr.service;

import java.util.List;

import com.mum.Ocr.model.Orders;


public interface IOrderService {
	List<Orders> getAllOrder();
	Orders getOrder(Long id);
	void add(Orders order) ;
	void update(Long id,Orders order);
	void deleteOrder(Long id);
}
