package com.dinesh.ds.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dinesh.ds.dao.CustomerDao;
import com.dinesh.ds.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	Session session = null;
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean Add(Customer c) throws Exception {
		// session = HibernateUtil.getHibernateUtil().getSession();
		session = sessionFactory.getCurrentSession();

		session.save(c);

		return true;
	}

	@Override
	@Transactional
	public boolean update(Customer c) throws Exception {
		// session = HibernateUtil.getHibernateUtil().getSession();
		session = sessionFactory.getCurrentSession();

		session.update(c);

		return true;
	}

	@Override
	@Transactional
	public boolean delete(int id) throws Exception {
		// session = HibernateUtil.getHibernateUtil().getSession();
		session = sessionFactory.getCurrentSession();
		Customer c = getByCustomerId(id);
		session.delete(c);
		System.out.println("Deleted");

		return true;
	}

	@Override
	@Transactional
	public List<Customer> getAll() throws Exception {
		session = sessionFactory.getCurrentSession();
		// session = HibernateUtil.getHibernateUtil().getSession();

		List<Customer> customers = (List<Customer>) session.createCriteria(Customer.class).list();

		return customers;
	}

	@Override
	@Transactional
	public Customer getByCustomerId(int id) throws Exception {
		// session = HibernateUtil.getHibernateUtil().getSession();
		session = sessionFactory.getCurrentSession();

		Customer c = (Customer) session.get(Customer.class, id);

		return c;
	}

}
