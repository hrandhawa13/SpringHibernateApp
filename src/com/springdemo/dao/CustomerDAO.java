package com.springdemo.dao;

import java.util.List;

import com.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void save(Customer temp);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
