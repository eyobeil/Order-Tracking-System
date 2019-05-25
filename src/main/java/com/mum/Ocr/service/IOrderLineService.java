package com.mum.Ocr.service;

import java.util.List;

import com.mum.Ocr.model.OrderLine;

public interface IOrderLineService {
	List<OrderLine> getAllOrderLine();
	OrderLine getOrderLine(Long id);
	void add(OrderLine orderLine) ;
	void update(Long id,OrderLine orderLine);
	void deleteOrderLine(Long id);
}
