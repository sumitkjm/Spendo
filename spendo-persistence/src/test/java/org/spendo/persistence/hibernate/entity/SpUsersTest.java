package org.spendo.persistence.hibernate.entity;

import junit.framework.Assert;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.spendo.persistence.entity.SpUsers;

public class SpUsersTest {
	
    private SessionFactory sessionFactory;
    private Session session;
	private static ServiceRegistry serviceRegistry;
	private Transaction tx = null;
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
	    tx = session.beginTransaction();
    }
    
    @Test
    public void readSpUsers() {
    	SpUsers spUsers = (SpUsers) session.get(SpUsers.class, 8);
    	Assert.assertEquals(spUsers.getEmailId(), "sumit.g.kumar@oracle.com");
    }
    
    @Test
    public void testSpUsersInsert() {
    	SpUsers spUsers = new SpUsers();
    	spUsers.setFirstName("Sumit");
    	spUsers.setLastName("Kumar");
    	spUsers.setCreatedBy("Sumit");
    	spUsers.setEmailId("sumit.g.kumar@oracle.com");
    	spUsers.setModifiedBy("Sumit");
    	spUsers.setUserLogin("sumit.g.kumar");
    	session.save(spUsers);
    	tx.commit();
//    	session.persist(spUsers);
//    	session.flush();
    }


	@After
    public void after() {
    	session.close();
    	sessionFactory.close();
    }
}
