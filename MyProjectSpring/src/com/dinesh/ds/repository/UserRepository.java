package com.dinesh.ds.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dinesh.ds.dao.UserDao;
import com.dinesh.ds.model.User;

@Service
public class UserRepository {
	
	@Autowired
	private UserDao userDao;


	public boolean Add(User u) throws Exception {
		return userDao.Add(u);
	}

	@Transactional
	public boolean update(User u) throws Exception {
		return userDao.update(u);
	}

	@Transactional
	public boolean delete(int id) throws Exception {
		return userDao.delete(id);
	}

	@Transactional
	public List<User> getAll() throws Exception {
		return userDao.getAll();
	}

	@Transactional
	public User getByUserId(int id) throws Exception {
		return userDao.getByUserId(id);
	}

	@Transactional
	public User getByUsername(String username) throws Exception {
		return userDao.getByUsername(username);
	}

}
