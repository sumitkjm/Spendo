package org.spendo.persistence;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.spendo.persistence.entity.SpExpenditureCategoryMast;

public class FeedHibUtil {
	
	private static final String GET_CATEGORY_BY_NAME = "select exp_category_id,category_name,category_description,created_by,modified_by,created_date,modified_date from sp_expenditure_category_mast where category_name=:expCategoryName";
	
	public SpExpenditureCategoryMast getSpExpCategoryById(int categoryId) {
		Session session = HibernateUtil.getSession();
		SpExpenditureCategoryMast spExpCategory = (SpExpenditureCategoryMast) session.get(SpExpenditureCategoryMast.class, categoryId);
		return spExpCategory;
	}
	
	public SpExpenditureCategoryMast getSpExpCategoryByName(String categoryName) throws SpPersistenceException {
		Session session = HibernateUtil.getSession();
		SQLQuery sqlQuery = session.createSQLQuery(GET_CATEGORY_BY_NAME);
		sqlQuery.setParameter("expCategoryName", categoryName);
		sqlQuery.addEntity(SpExpenditureCategoryMast.class);
		List<SpExpenditureCategoryMast> spExpenditureCategoryMasts = sqlQuery.list();
		if(spExpenditureCategoryMasts.size()!=1) {
			throw new SpPersistenceException("Expected Result 1 found:"+spExpenditureCategoryMasts.size());
		}
		return spExpenditureCategoryMasts.get(0);
	}
	
	public List<SpExpenditureCategoryMast> getAllCategories() {
		List<SpExpenditureCategoryMast> spExpenditureCategoryMasts = null;
		Session session = HibernateUtil.getSession();
		SQLQuery sqlQuery = session.createSQLQuery("select exp_category_id,category_name,category_description,created_by,modified_by,created_date,modified_date from sp_expenditure_category_mast");
		sqlQuery.addEntity(SpExpenditureCategoryMast.class);
		spExpenditureCategoryMasts = sqlQuery.list();
		return spExpenditureCategoryMasts;
	}
	
	public void deleteExpenditureCategoryByName(String categoryName) {
		Session session = HibernateUtil.getSession();
	}

	public void persistExpenditureCategoryMast(
			SpExpenditureCategoryMast spExpenditureCategoryMast) {
		Session session = HibernateUtil.getSession();
		Transaction tx =  session.beginTransaction();
		session.save(spExpenditureCategoryMast);
		tx.commit();
	}
	
	

}
