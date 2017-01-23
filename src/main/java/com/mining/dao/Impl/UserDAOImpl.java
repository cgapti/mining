package com.mining.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mining.dao.AbstractDao;
import com.mining.dao.UserDAO;
import com.mining.exception.MiningException;
import com.mining.model.StoneImage;
import com.mining.model.User;
import com.mining.model.JSON.StoneImageInfo;
import com.mining.model.JSON.UserInfo;
import com.mining.util.MiningConstants;

@Repository("userDAOImpl")
public class UserDAOImpl extends AbstractDao<Integer, User> implements
		UserDAO {
	final static Logger logger = LoggerFactory
			.getLogger(UserDAOImpl.class);
	
	public String saveUser(User user) throws MiningException {
		logger.debug("saveUser method starts");
		saveOrUpdate(user);
		logger.debug("saveUser method ends");
		return MiningConstants.success;
	}

	/**
	 * loginUser
	 * 
	 */
	@SuppressWarnings("unchecked")
	public UserInfo loginUser(UserInfo userInfo) throws MiningException {
		logger.debug("loginUser method starts");
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
			logger.error(
					"Error occured while fetching the data from DB", e.getMessage());
			throw new MiningException(
					"Error occured while fetching the data from DB", e.getMessage());
		}
		logger.debug("loginUser method ends");
		return userInfoRes;
	}
	
	/**
	 * forgotPassword
	 * 
	 */
	@SuppressWarnings("unchecked")
	public UserInfo forgotPassword(UserInfo userInfo) throws MiningException {
		logger.debug("forgotPassword method starts");
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
			logger.error(
					"Error occured while fetching the data from DB", e.getMessage());
			throw new MiningException(
					"Error occured while fetching the data from DB", e.getMessage());
		}
		logger.debug("forgotPassword method ends");
		return userInfoRes;
	}

	@SuppressWarnings("unchecked")
	public List<StoneImageInfo> getAllImages() throws MiningException {
		logger.debug("getAllImages method starts");
		List<StoneImageInfo> imageList = new ArrayList<StoneImageInfo>();
		Session session = null;
		Transaction trans = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			Query query = session.createQuery("from StoneImage");//here persistent class name is Emp  
			List<StoneImage> Querylist = query.list();
			if(null != Querylist) {
				for(StoneImage stoneImage : Querylist) {
					StoneImageInfo stoneImageInfo = new StoneImageInfo();
					stoneImageInfo.setImgeName(stoneImage.getImageName());
					stoneImageInfo.setImage(stoneImage.getImage());
					imageList.add(stoneImageInfo);
				}
			}			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			logger.error(
					"Error occured while fetching the data from DB", e.getMessage());
			throw new MiningException(
					"Error occured while fetching the data from DB", e.getMessage());
		}
		logger.debug("getAllImages method ends");
		return imageList;
	}

}
