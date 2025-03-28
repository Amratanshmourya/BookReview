	package com.java.bookreview.util;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	 private static SessionFactory sessionFactory;
	    
	    static {
	        try {
	        	if(sessionFactory == null) {
	        		sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	        	}
	            //sessionFactory = new Configuration().configure().buildSessionFactory();
	        } catch (Throwable ex) {
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
}
