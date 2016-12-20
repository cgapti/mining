package com.mining.service.Impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mining.bo.MiningBO;
import com.mining.dao.UserDAO;
import com.mining.exception.MiningException;
import com.mining.model.User;
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

	public String saveUser(UserInfo userInfo) throws MiningException {
		System.out.println("UserServiceImpl - saveUser method starts");
		System.out.println("UserServiceImpl - saveUser method ends");
		return userDAOImpl.saveUser(processUserInfo(userInfo));
	}

	private User processUserInfo(UserInfo userInfo) {
		System.out.println("UserServiceImpl - processUserInfo method starts");
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
		System.out.println("UserServiceImpl - processUserInfo method starts");
		return user;
	}

	public String loginUser(UserInfo userInfo) throws MiningException {
		System.out.println("UserServiceImpl - loginUser method starts");
		System.out.println("UserServiceImpl - loginUser method ends");
		return miningBO.loginUser(userInfo);
	}

	public String forgotPassword(UserInfo userInfo) throws MiningException {		
		System.out.println("UserServiceImpl - processUserInfo method starts");
		String res = "failed";
		UserInfo userInfoFromDB = userDAOImpl.forgotPassword(userInfo);
		if(null != userInfoFromDB) {
			mailServiceImpl.sendEmail(userInfoFromDB);
			res = "success";
		}		
		System.out.println("UserServiceImpl - processUserInfo method starts");
		return res;
	}

}
