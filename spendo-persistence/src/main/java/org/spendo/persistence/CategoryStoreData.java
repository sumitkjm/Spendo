package org.spendo.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.spendo.persistence.entity.SpExpenditureCategoryMast;



public class CategoryStoreData {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public SpExpenditureCategoryMast fetchCategoryData(int categoryId) {
		if (sessionFactory == null) {
			initializeSessionFactory();
		}
		// creating session object
		Session session = sessionFactory.openSession();

		SpExpenditureCategoryMast spExpenditureCategoryMast = (SpExpenditureCategoryMast) session
				.get(SpExpenditureCategoryMast.class, categoryId);
		return spExpenditureCategoryMast;
	}

	private static void initializeSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		// populates the data of the
		// configuration file
		// creating seession factory object
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(
	    		cfg.getProperties()).buildServiceRegistry();
	    sessionFactory = cfg.buildSessionFactory(serviceRegistry);
	}

}
