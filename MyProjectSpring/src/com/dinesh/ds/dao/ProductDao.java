package com.dinesh.ds.dao;

import java.util.List;

import com.dinesh.ds.model.Product;

public interface ProductDao {

	
	boolean Add(Product p) throws Exception;

	boolean update(Product c) throws Exception;

	boolean delete(int id) throws Exception;
	
	List<Product> getAll() throws Exception;
	
	List<Product> listOfActiveProduct() throws Exception;

	Product getByProductId(int id) throws Exception; 
	

}
