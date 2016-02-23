package org.spendo.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	/**
	 * Open the session from sessionFactory.
	 * @return Session Object opened
	 */
	public static Session getSession() {
		if (sessionFactory == null) {
			initializeSessionFactory();
		}
		// creating session object
		Session session = sessionFactory.openSession();
		return session;
	}

	private static void initializeSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		// populates the data of the
		// configuration file
		// creating session factory object
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(
	    		cfg.getProperties()).buildServiceRegistry();
	    sessionFactory = cfg.buildSessionFactory(serviceRegistry);
	}
	
	/**
	 * Closes the session if it's open
	 * @param session Session Object
	 */
	public static void closeSession(Session session) {
		if(session!=null && session.isOpen()) {
			session.close();
		}
	}

}
