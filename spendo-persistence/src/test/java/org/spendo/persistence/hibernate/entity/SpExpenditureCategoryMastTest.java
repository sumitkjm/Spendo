package org.spendo.persistence.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.spendo.persistence.entity.SpExpenditureCategoryMast;

public class SpExpenditureCategoryMastTest {

    private SessionFactory sessionFactory;
    private Session session;
	private static ServiceRegistry serviceRegistry;

    @Before
    public void before() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		// populates the data of the
		// configuration file
		// creating seession factory object
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(
	    		cfg.getProperties()).buildServiceRegistry();
	    sessionFactory = cfg.buildSessionFactory(serviceRegistry);
	    session = sessionFactory.openSession();
//    	session.beginTransaction();
    }
    
    @Test
    public void testRead() {
		SpExpenditureCategoryMast spExpenditureCategoryMast = (SpExpenditureCategoryMast) session
				.get(SpExpenditureCategoryMast.class, 2);
		Assert.assertTrue("Medical".equals(spExpenditureCategoryMast.getCategoryName()));
		System.out.println(spExpenditureCategoryMast.getCategoryName());
    }

	@After
    public void after() {
    	session.close();
    	sessionFactory.close();
    }

	
}
