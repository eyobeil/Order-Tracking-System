package com.mum.Ocr.service;

import java.util.List;

import com.mum.Ocr.model.Customer;

public interface ICustomerService {
	List<Customer> getAllCustomers();
	Customer getCustomer(long id);
	Customer add(Customer customer) ;
	void update(Customer customer);
	void deleteCustomer(long id);
	Customer findOne(Long id);
	Customer findByEmail(String email);
}
