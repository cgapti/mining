package com.mining.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.mining.exception.MiningException;

public abstract class AbstractDao<PK extends Serializable, T> {

	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() throws MiningException {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) throws MiningException {
		return (T) getSession().get(persistentClass, key);
	}

	public void persist(T entity) throws MiningException {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		session.persist(entity);
		trans.commit();
	}

	public void saveOrUpdate(T entity) throws MiningException {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		session.saveOrUpdate(entity);
		trans.commit();

	}

	public void delete(T entity) throws MiningException {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		session.delete(entity);
		trans.commit();
	}

	protected Criteria createEntityCriteria() throws MiningException {
		return getSession().createCriteria(persistentClass);
	}

}