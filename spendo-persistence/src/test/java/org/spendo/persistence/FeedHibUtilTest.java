package org.spendo.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.spendo.commons.vo.json.ExpCategory;
import org.spendo.persistence.entity.SpExpenditureCategoryMast;

public class FeedHibUtilTest {
	
    private SessionFactory sessionFactory;
    private Session session;
	private static ServiceRegistry serviceRegistry;
	private Transaction tx = null;
	private FeedHibUtil feedHibUtil = null;
	
    @Before
    public void before() {
    	feedHibUtil = new FeedHibUtil();
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
    public void testGetCategoryById() {
    	SpExpenditureCategoryMast expCategory = feedHibUtil.getSpExpCategoryById(1);
    	Assert.assertEquals("TestJunitCategory", expCategory.getCategoryName());
    }
    
    @Test
    public void testAllCategories() {
    	feedHibUtil.getAllCategories();
    }
    
    @Test(expected=SpPersistenceException.class)
    public void testGetCategoryByNameWithException() throws SpPersistenceException {
    	SpExpenditureCategoryMast spExpenditureCategoryMast = feedHibUtil.getSpExpCategoryByName("CategoryNameNotStored");
    	Assert.assertEquals("Food", spExpenditureCategoryMast.getCategoryName());
    }
    
    @Test
    public void testGetCategoryByName() throws SpPersistenceException {
    	SpExpenditureCategoryMast spExpenditureCategoryMast = feedHibUtil.getSpExpCategoryByName("Food");
    	Assert.assertEquals("Food", spExpenditureCategoryMast.getCategoryName());
    }
    
    @Test
    public void testPersistCategory() throws SpPersistenceException {
    	SpExpenditureCategoryMast spExpenditureCategoryMast = new SpExpenditureCategoryMast();
    	spExpenditureCategoryMast.setCategoryName("TestJunitCategory");
    	spExpenditureCategoryMast.setCategoryDescription("Test JunitCategory Description");
//    	spExpenditureCategoryMast.setExpCategoryId(1111);
    	feedHibUtil.persistExpenditureCategoryMast(spExpenditureCategoryMast);
    	SpExpenditureCategoryMast persistedCategoryMast = feedHibUtil.getSpExpCategoryByName("TestJunitCategory");
    	Assert.assertEquals(spExpenditureCategoryMast.getCategoryName(), persistedCategoryMast.getCategoryName());
    	Assert.assertEquals(spExpenditureCategoryMast.getCategoryDescription(), persistedCategoryMast.getCategoryDescription());
    	tx.rollback();
    }
    
    @After
    public void after() {
    	HibernateUtil.closeSession(session);
    }

}
