package com.mum.Ocr.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.Ocr.model.Customer;
import com.mum.Ocr.repositroty.CustomerRepository;
import com.mum.Ocr.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
public List<Customer> getAllCustomers(){
	List<Customer> allCustomers=new ArrayList<>();
	customerRepository.findAll()
	 .forEach(allCustomers::add);
    return allCustomers;
}
public Customer getCustomer(long id) {
	return customerRepository.getOne(id);
}
public Customer add(Customer customer) {
	return customerRepository.save(customer);
	
}
public void update(Customer customer) {
	customerRepository.save(customer)	;
}
public void deleteCustomer(long id) {
	customerRepository.deleteById(id);
	
	
}
public Customer findOne(Long id) {
	// TODO Auto-generated method stub
	return customerRepository.getOne(id);
}
@Override
public Customer findByEmail(String email) {
	return customerRepository.findByEmail(email);
	
}
}
