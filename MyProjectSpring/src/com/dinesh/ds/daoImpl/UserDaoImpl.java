package com.dinesh.ds.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dinesh.ds.dao.UserDao;
import com.dinesh.ds.model.User;
import com.dinesh.ds.util.HibernateUtil;

@Repository
public class UserDaoImpl implements UserDao {

	Session session = null;
	
	@Autowired
	SessionFactory sessionFactory;

	@Override 
	@Transactional
	public boolean Add(User u) throws Exception {
		//session = HibernateUtil.getHibernateUtil().getSession(); 
		
		session = sessionFactory.getCurrentSession();
		session.save(u);
		return true;
	}

	@Override 
	@Transactional
	public boolean update(User u) throws Exception {
		//session = HibernateUtil.getHibernateUtil().getSession();
		session = sessionFactory.getCurrentSession();
		
		session.update(u);
		
		

		return true;
	}

	@Override 
	@Transactional
	public boolean delete(int id) throws Exception {
		//session = HibernateUtil.getHibernateUtil().getSession(); 
		session = sessionFactory.getCurrentSession();
		User u = getByUserId(id);
		session.delete(u);
		System.out.println("Deleted");

		

		return true;
	}

	@Override 
	@Transactional
	public List<User> getAll() throws Exception {
		//session = HibernateUtil.getHibernateUtil().getSession(); 
		session = sessionFactory.getCurrentSession();
		List<User> users = (List<User>) session.createCriteria(User.class).list();
		
		return users;
	}

	@Override 
	@Transactional
	public User getByUserId(int id) throws Exception {
		//session = HibernateUtil.getHibernateUtil().getSession();
		session = sessionFactory.getCurrentSession();
		User u = (User) session.get(User.class, id);
		
		return u;
	}

	@Override 
	@Transactional
	public User getByUsername(String username) throws Exception {
		//session = HibernateUtil.getHibernateUtil().getSession(); 
		session = sessionFactory.getCurrentSession();
		// Query q=session.createQuery("From User where
		// username=?").setParameter("username", username);

		// User u=(User)q.list().get(0);
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("username", username));
		List results = cr.list();
		User u = (User) cr.list().get(0);
		
		return u;
	}

}
