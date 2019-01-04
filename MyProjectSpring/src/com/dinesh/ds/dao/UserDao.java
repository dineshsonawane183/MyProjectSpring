package com.dinesh.ds.dao;

import java.util.List;

import com.dinesh.ds.model.User;

public interface UserDao {

	boolean Add(User u) throws Exception;

	boolean update(User u) throws Exception;

	boolean delete(int id) throws Exception;
	
	List<User> getAll() throws Exception;

	User getByUserId(int id) throws Exception; 
	User getByUsername(String username) throws Exception; 

	
	
}
