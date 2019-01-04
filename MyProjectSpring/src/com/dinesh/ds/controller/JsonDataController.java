package com.dinesh.ds.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dinesh.ds.dao.ProductDao;
import com.dinesh.ds.model.Customer;
import com.dinesh.ds.model.Product;
import com.dinesh.ds.model.User;
import com.dinesh.ds.repository.CustomerRepository;
import com.dinesh.ds.repository.ProductRepository;
import com.dinesh.ds.repository.UserRepository;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "json/data", produces = "application/json")
public class JsonDataController {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	UserRepository userRepository;


	@RequestMapping(value = "getAllProducts")
	@ResponseBody
	public String getAllProductList(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		List<Product> products = productRepository.getAll();
		String ProductJsonString = new Gson().toJson(products);
		return ProductJsonString;
	}

	
	@RequestMapping(value = "getAllActiveProducts")
	@ResponseBody
	public String getAllActiveProducts(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		List<Product> products = productRepository.listOfActiveProduct();
		String ProductJsonString = new Gson().toJson(products);
		return ProductJsonString;
	}

	
	
	
	
	
	@RequestMapping(value = "getAllCustomers")
	@ResponseBody
	public String getAllCustomerList(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		List<Customer> customers=customerRepository.getAll();
		String cst = new Gson().toJson(customers);
		return cst;
	}
	
	
	
	
	
	@RequestMapping(value = "getAllUsers")
	@ResponseBody
	public String getAllUsers(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		List<User> users=userRepository.getAll();
		String cst = new Gson().toJson(users);
		return cst;
	}

}
