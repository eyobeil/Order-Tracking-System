package com.mum.Ocr.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.Ocr.model.OrderLine;
import com.mum.Ocr.repositroty.OrderLineRepository;
import com.mum.Ocr.service.IOrderLineService;

@Service
public class OrderLineService implements IOrderLineService{
	@Autowired
	private OrderLineRepository orderLineRepository;
	
	@Override
public List<OrderLine> getAllOrderLine(){
	List<OrderLine> allOrderLines=new ArrayList<>();
	orderLineRepository.findAll()
	 .forEach(allOrderLines::add);
    return allOrderLines;
}

public OrderLine getOrderLine(Long id) {
	return orderLineRepository.findById(id).get();
}
public void add(OrderLine orderLine) {
	orderLineRepository.save(orderLine);
	
}
public void update(Long id,OrderLine orderLine) {
	orderLineRepository.save(orderLine);	
}

@Override
public void deleteOrderLine(Long id) {
	orderLineRepository.deleteById(id);
	
}
}