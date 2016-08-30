package com.spring.gradle.shopping.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Dao<T> {
	@Autowired
	private SessionFactory sessionFactory;

	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public Collection<T> getAll(T obj) {
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<T> resultList = null;
		try {
			Criteria criteria = session.createCriteria(obj.getClass());
			resultList = criteria.list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			// TODO: handle exception
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return (Collection<T>) resultList;

	}
}
