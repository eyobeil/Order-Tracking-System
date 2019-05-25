package com.mum.Ocr.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mum.Ocr.model.Orders;
import com.mum.Ocr.repositroty.OrderRepository;
import com.mum.Ocr.service.IOrderService;
@Service
public class OrderService implements IOrderService{
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Orders> getAllOrder() {
		List<Orders> allOrder=new ArrayList<>();
		orderRepository.findAll()
		 .forEach(allOrder::add);
	    return allOrder;
	}

	@Override
	public Orders getOrder(Long id) {
		return orderRepository.getOne(id);
	}

	@Override
	public void add(Orders order) {
		orderRepository.save(order);
		
	}

	@Override
	public void update(Long id, Orders order) {
		orderRepository.save(order);
		
	}

	@Override
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
		
	}
	

	

}
