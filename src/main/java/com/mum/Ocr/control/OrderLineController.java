package com.mum.Ocr.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mum.Ocr.model.Customer;
import com.mum.Ocr.model.OrderLine;

import com.mum.Ocr.service.IOrderLineService;

//@RestController
public class OrderLineController {
	@Autowired
	private IOrderLineService OrderLineService;
	
	@RequestMapping("/orderLine")
	public List<OrderLine> getAllOrderLine() {
		return OrderLineService.getAllOrderLine();
	}
	
	@RequestMapping("/orderLine/{id}")
	public OrderLine getOrderLine(@PathVariable Long id) {
		return OrderLineService.getOrderLine(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/orderLine")
	public void addCustomer(@RequestBody OrderLine orderLine) {
		//identify a customer type by customer ratting 
//		if(customer.getRate().equals(CustomerRatting.EXCELLENT)) {
//			customer.setRate(CustomerRatting.EXCELLENT);
//		}
			
		OrderLineService.add(orderLine);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/orderLine/{id}")
	public void editCusomer(@RequestBody OrderLine customer,@PathVariable Long id) {
		OrderLineService.update(id,customer);
	}
	@RequestMapping(value="/customersOr/{id}",method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable Long id) {
		 OrderLineService.deleteOrderLine(id);
	}
}
