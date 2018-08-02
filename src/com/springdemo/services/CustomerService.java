package com.springdemo.services;

import java.util.List;

import com.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void save(Customer temp);

	public Customer getCustomer(int id);

	public void deleteCusotmer(int id);
}
