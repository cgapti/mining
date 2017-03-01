package com.mining.service.Impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mining.bo.MiningBO;
import com.mining.dao.UserDAO;
import com.mining.exception.MiningException;
import com.mining.model.User;
import com.mining.model.JSON.StatusInfo;
import com.mining.model.JSON.StoneImageInfo;
import com.mining.model.JSON.UserApprovelInfo;
import com.mining.model.JSON.UserInfo;
import com.mining.service.MailService;
import com.mining.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAOImpl;
	
	@Autowired
	private MailService mailServiceImpl;

	@Autowired
	private MiningBO miningBO;
	
	final static Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class);
	
	/**
	 * saveUser
	 * 
	 */
	public String saveUser(UserInfo userInfo) throws MiningException {
		logger.debug("saveUser method starts");
		logger.debug("saveUser method ends");
		return userDAOImpl.saveUser(processUserInfo(userInfo));
	}
	
	/**
	 * processUserInfo
	 * 
	 */
	private User processUserInfo(UserInfo userInfo) {
		logger.debug("processUserInfo method starts");
		User user = new User();
		if (null != userInfo) {
			user.setUserName(userInfo.getUserName());
			user.setPassword(userInfo.getPassword());
			user.setPhoneNumber(userInfo.getPhoneNumber());
			user.setRole(userInfo.getRole());
			user.setEmail(userInfo.getEmail());
			user.setCreatedBy(userInfo.getUserName());
			user.setCreationDate(new Date());
		}
		logger.debug("processUserInfo method ends");
		return user;
	}
	
	/**
	 * loginUser
	 * 
	 */
	public String loginUser(UserInfo userInfo) throws MiningException {
		logger.debug("loginUser method starts");
		logger.debug("loginUser method ends");
		return miningBO.loginUser(userInfo);
	}
	
	/**
	 * forgotPassword
	 * 
	 */
	public String forgotPassword(UserInfo userInfo) throws MiningException {		
		logger.debug("forgotPassword method starts");
		String res = "failed";
		UserInfo userInfoFromDB = userDAOImpl.forgotPassword(userInfo);
		if(null != userInfoFromDB) {
			mailServiceImpl.sendEmail(userInfoFromDB);
			res = "success";
		}		
		logger.debug("forgotPassword method ends");
		return res;
	}

	public List<StoneImageInfo> getAllImages() throws MiningException {
		logger.debug("getAllImages method starts");
		logger.debug("getAllImages method ends");
		return userDAOImpl.getAllImages();
	}
	
	/**
	 * Method to get the URL from DB
	 */
	public String getServerUrl() throws MiningException {
		return userDAOImpl.getServerUrl();
	}
	@Override
	public List<UserInfo> getPendingApprovels(String searchBy,String searchVal) throws MiningException {
		logger.debug("get pending approvels list service impl starts");
		return userDAOImpl.getPendingApprovels(searchBy,searchVal);
	}

	@Override
	public String saveUserApprovel(UserApprovelInfo appInfo)
			throws MiningException {
		logger.debug("save user approvel values in user Service Impl");
		return userDAOImpl.saveUserApprovel(appInfo);
	}

	@Override
	public List<StatusInfo> getStatusValues(Integer statusId) throws MiningException {
		logger.debug("get status values list service impl starts");
		return userDAOImpl.getStatusValues(statusId);
	}
}
