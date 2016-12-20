package com.mining.dao.Impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.mining.dao.AbstractDao;
import com.mining.dao.UserDAO;
import com.mining.exception.MiningException;
import com.mining.model.User;
import com.mining.model.JSON.UserInfo;

@Repository("userDAOImpl")
public class UserDAOImpl extends AbstractDao<Integer, User> implements
		UserDAO {

	public String saveUser(User user) throws MiningException {
		System.out.println("MiningDAOImpl - saveUser method starts");
		saveOrUpdate(user);
		System.out.println("MiningDAOImpl - saveUser method starts");
		return "success";
	}

	@SuppressWarnings("unchecked")
	public UserInfo loginUser(UserInfo userInfo) throws MiningException {

		UserInfo userInfoRes = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			String sql = "SELECT USER_NAME, USER_PASSWORD FROM TBL_USER_REGISTRATION WHERE USER_NAME= '"
					+ userInfo.getUserName() + "'";
			SQLQuery query = session.createSQLQuery(sql);
			List<Object[]> results = query.list();
			if (null != results && !results.isEmpty()) {
				userInfoRes = new UserInfo();
				Object[] row = results.get(0);
				userInfoRes.setUserName(row[0].toString());
				userInfoRes.setPassword(row[1].toString());
			}
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw new MiningException(
					"Error occured while fetching the data from DB", e.getMessage());
		}
		return userInfoRes;
	}

	public UserInfo forgotPassword(UserInfo userInfo) throws MiningException {
		UserInfo userInfoRes = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			String sql = "SELECT USER_NAME, USER_PASSWORD FROM TBL_USER_REGISTRATION WHERE EMAIL= '"
					+ userInfo.getEmail() + "'";
			SQLQuery query = session.createSQLQuery(sql);
			List<Object[]> results = query.list();
			if (null != results && !results.isEmpty()) {
				userInfoRes = new UserInfo();
				Object[] row = results.get(0);
				userInfoRes.setUserName(row[0].toString());
				userInfoRes.setPassword(row[1].toString());
				userInfoRes.setEmail(userInfo.getEmail());
			}
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw new MiningException(
					"Error occured while fetching the data from DB", e.getMessage());
		}
		return userInfoRes;
	}

}
