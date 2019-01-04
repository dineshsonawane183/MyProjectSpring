package com.dinesh.ds.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	

		
		
		private static HibernateUtil hibernateUtil;
		private HibernateUtil() {
			super();
		}
		
		public static HibernateUtil getHibernateUtil() {
			if(hibernateUtil==null) {
				synchronized (HibernateUtil.class) {
					if(hibernateUtil==null) {
						hibernateUtil=new HibernateUtil();
					}
					
				}
			}
			return hibernateUtil;
		}
		
		public  Session getSession()  {
			Session session = null;
			SessionFactory sessionFactory=null;
			try {
			
//				Configuration configuration = new Configuration();
//                    configuration.configure("hibernate.cfg.xml");
//                    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                            .applySettings(configuration.getProperties()).build();
//                    sessionFactory = configuration
//                            .buildSessionFactory(serviceRegistry);
//                    session=sessionFactory.getCurrentSession();
				session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
                    return session;
			} catch (Exception e) {
		
			e.printStackTrace();
			}
			return session;
			
			
		}
		
		
	}

