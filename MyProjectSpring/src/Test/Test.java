/*package Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.dinesh.ds.model.User;
import com.dinesh.ds.model.UserType;
@Component
@Transactional
public class Test {

	@Autowired
	SessionFactory sessionFactory;
	
	

 

	  public void save() { 
		  
		  System.out.println("helloa");
		  System.out.println(sessionFactory);
		  Session session= sessionFactory.getCurrentSession();
	     session.save(new User("name",UserType.ADMIN, "username","password" ));
	     System.out.println("helloa");
	   }

   public static void main(String[] args) {
	
	  new Test().save();
} 
}
*/