package com.dinesh.ds.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dinesh.ds.dao.CustomerDao;
import com.dinesh.ds.model.Customer;
@Component
public class CustomerRepository {
	@Autowired
	private CustomerDao customerDao;
	@Transactional
	public boolean Add(Customer c) throws Exception {
		return customerDao.Add(c);
	}
	@Transactional
	public boolean update(Customer c) throws Exception {
		return customerDao.update(c);
	}
	@Transactional
	public boolean delete(int id) throws Exception {
		return customerDao.delete(id);
	}
	@Transactional
	public List<Customer> getAll() throws Exception {
		return customerDao.getAll();
	}
	@Transactional
	public Customer getByCustomerId(int id) throws Exception {
		return customerDao.getByCustomerId(id);
	}
}
