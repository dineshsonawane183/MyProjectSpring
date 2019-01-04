package com.dinesh.ds.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dinesh.ds.dao.ProductDao;
import com.dinesh.ds.model.Product;
@Component
public class ProductRepository {

	@Autowired
	private ProductDao productDao;
	


	@Transactional
	public boolean Add(Product p) throws Exception {
		return productDao.Add(p);
	}
	@Transactional
	public boolean update(Product p) throws Exception {
		return productDao.update(p);
	}
	@Transactional
	public boolean delete(int id) throws Exception {
		return productDao.delete(id);
	}

	public List<Product> getAll() throws Exception {
		return productDao.getAll();
	}
	@Transactional
	public List<Product> listOfActiveProduct() throws Exception {
		return productDao.listOfActiveProduct();
	}
	@Transactional
	public Product getByProductId(int id) throws Exception {
		return productDao.getByProductId(id);
	}

}
