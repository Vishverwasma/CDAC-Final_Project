package com.app.springdemo.service;

import java.util.List;

import com.app.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

}
