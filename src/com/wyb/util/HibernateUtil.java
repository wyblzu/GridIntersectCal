package com.wyb.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.wyb.model.*;

/**
 * The HibernateUtil class helps in creating the SessionFactory
 * from the Hibernate configuration file
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class HibernateUtil {

	public static SessionFactory sessionFactory(Class model){
		SessionFactory sessionFactory;
		try {
			sessionFactory = new AnnotationConfiguration()
					.configure()
					.addPackage("com.wyb.model") //the fully qualified package name
					.addAnnotatedClass(model)
					.buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return sessionFactory;
	}

}