package com.mining.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mining.exception.MiningException;

public abstract class AbstractDao<PK extends Serializable, T> {
	
	final static Logger logger = LoggerFactory
			.getLogger(AbstractDao.class);

	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() throws MiningException {
		logger.debug("getSession method starts");
		Session session = sessionFactory.getCurrentSession();
		if (null == session) {
			session = sessionFactory.openSession();
		}
		logger.debug("getSession method ends");
		return session;
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) throws MiningException {
		return (T) getSession().get(persistentClass, key);
	}

	public void persist(T entity) throws MiningException {
		logger.debug("persist method starts");
		Session session = null;
		Transaction trans = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			session.persist(entity);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			logger.error("Error occured:", e.getMessage());
			throw new MiningException("Error occured:", e.getMessage());
		}
		logger.debug("persist method ends");
	}

	public void saveOrUpdate(T entity) throws MiningException {
		logger.debug("saveOrUpdate method starts");
		Session session = null;
		Transaction trans = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			session.saveOrUpdate(entity);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			logger.error("Error occured:", e.getMessage());
			throw new MiningException("Error occured:", e.getMessage());
		}
		logger.debug("saveOrUpdate method ends");
	}

	public void delete(T entity) throws MiningException {
		logger.debug("delete method starts");
		Session session = null;
		Transaction trans = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			session.delete(entity);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			logger.error("Error occured:", e.getMessage());
			throw new MiningException("Error occured:", e.getMessage());
		}
		logger.debug("delete method ends");
	}

	protected Criteria createEntityCriteria() throws MiningException {
		return getSession().createCriteria(persistentClass);
	}

}