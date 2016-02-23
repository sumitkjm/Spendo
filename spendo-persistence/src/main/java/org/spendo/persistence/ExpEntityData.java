package org.spendo.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.spendo.persistence.entity.SpExpenditureEntity;

public class ExpEntityData {
	
	public SpExpenditureEntity fetch(int id) {
		SpExpenditureEntity spExpenditureEntity = (SpExpenditureEntity) HibernateUtil.getSession().get(SpExpenditureEntity.class, id);
		return spExpenditureEntity;
	}
	
	public void persist(SpExpenditureEntity spExpenditureEntity) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(spExpenditureEntity);
		tx.commit();
	}

}
