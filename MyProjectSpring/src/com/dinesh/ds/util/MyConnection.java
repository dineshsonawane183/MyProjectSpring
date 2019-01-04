package com.dinesh.ds.util;

import java.sql.SQLException;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.dinesh.ds.model.Customer;
import com.dinesh.ds.model.Feedback;
import com.dinesh.ds.model.Product;
import com.dinesh.ds.model.User;
import com.dinesh.ds.model.UserType;
import com.dinesh.ds.repository.CustomerRepository;
import com.dinesh.ds.repository.ProductRepository;
import com.dinesh.ds.repository.UserRepository;
import com.telusko.tusk.dao.FeedbackDao;

public class MyConnection {

	public static void main(String[] args) throws Exception {
		// Connection con = ConnectionUtil.getConnection().getDBConnection();
		// if (con != null) {
		// System.out.println("connected");
		// } else {
		// System.out.println("not connected");
		// }

		// Session session=HibernateUtil.getHibernateUtil().getSession();
		// System.out.println(session.isConnected());
		//

		// boolean res=CustomerRepository.getRepository().Add(new Customer("name",
		// "address", "contact", "imageUrl"));
		// boolean res=CustomerRepository.getRepository().update(new Customer(1,"anil",
		// "address", "contact", "imageUrl"));
		// boolean res=CustomerRepository.getRepository().delete(1);
		// System.out.println(session.isConnected());

	//CustomerRepository.getRepository().getAll().forEach(System.out::println);

		/*
		 * 
		 * Product test
		 * 
		 */

//	 boolean res=ProductRepository.getRepository().Add(new Product("name",
//	 "brand", "description", 100d,100 , true));
		// boolean res=ProductRepository.getRepository().Add(new Product("name1",
		// "brand1", "description", 100d,100 , false));
		// boolean res=ProductRepository.getRepository().update(new Product(1,"xyz",
		// "brand", "description", 100d,100 , true));
		// System.out.println(ProductRepository.getRepository().getByProductId(1));
		// System.out.println(res);
		// ProductRepository.getRepository().delete(1);
		// ProductRepository.getRepository().getAll().forEach(System.out::println);
		// ProductRepository.getRepository().listOfActiveProduct().forEach(System.out::println);
	
	
	
		/*
		 * 
		 * User test
		 * 
		 */
	
		
//UserRepository.getRepository().Add(new User("name", UserType.CUSTOMER, "username1"," password"));
	
		//UserRepository.getRepository().update(new User(1,"name1", UserType.ADMIN, "username1"," password11"));
		//UserRepository.getRepository().getAll().forEach(System.out::println);
	//System.out.println(UserRepository.getRepository().getByUserId(1).toString());
	//System.out.println(UserRepository.getRepository().getByUsername("username1"));
		
		
		
		
	
		
		
	}

}
