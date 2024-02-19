package com.app.springdemo.dao;

import java.util.List;

import com.app.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

}
