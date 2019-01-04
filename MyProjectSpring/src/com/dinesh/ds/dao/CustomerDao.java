package com.dinesh.ds.dao;

import java.util.List;

import com.dinesh.ds.model.Customer;

public interface CustomerDao {

	boolean Add(Customer c) throws Exception;

	boolean update(Customer c) throws Exception;

	boolean delete(int id) throws Exception;
	
	List<Customer> getAll() throws Exception;

	Customer getByCustomerId(int id) throws Exception; 

}
