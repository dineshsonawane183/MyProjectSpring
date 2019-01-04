package com.dinesh.ds.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dinesh.ds.dao.ProductDao;
import com.dinesh.ds.model.Product;
import com.dinesh.ds.util.HibernateUtil;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;
	Session session = null;

	@Override
	@Transactional
	public boolean Add(Product p) throws Exception {
		// session = HibernateUtil.getHibernateUtil().getSession();
		session = sessionFactory.getCurrentSession();
		session.save(p);
		return true;
	}

	@Override
	@Transactional
	public boolean update(Product p) throws Exception {
		// session = HibernateUtil.getHibernateUtil().getSession();
		session = sessionFactory.getCurrentSession();
		session.update(p);
		return true;
	}

	@Override
	@Transactional
	public boolean delete(int id) throws Exception {
		// session = HibernateUtil.getHibernateUtil().getSession();
		session = sessionFactory.getCurrentSession();
		Product p = getByProductId(id);
		session.delete(p);
		System.out.println("Deleted");

		return true;
	}

	@Override
	@Transactional
	public List<Product> getAll() throws Exception {
		// session = HibernateUtil.getHibernateUtil().getSession();
		session = sessionFactory.getCurrentSession();
		List<Product> products = (List<Product>)session.createQuery("from Product").list();
		products.forEach(System.out::println);
		return products;
	}

	@Override
	@Transactional
	public Product getByProductId(int id) throws Exception {
		// session = HibernateUtil.getHibernateUtil().getSession();
		session = sessionFactory.getCurrentSession();
		Product p = (Product) session.get(Product.class, id);
		return p;
	}

	@Override
	@Transactional
	public List<Product> listOfActiveProduct() throws Exception {
		// session = HibernateUtil.getHibernateUtil().getSession();
		session = sessionFactory.getCurrentSession();
		Criteria c1 = session.createCriteria(Product.class).add(Restrictions.eq("active", true));
		List<Product> products = c1.list();
		return products;
	}

}
