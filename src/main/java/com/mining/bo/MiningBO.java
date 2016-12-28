package com.mining.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mining.dao.UserDAO;
import com.mining.exception.MiningException;
import com.mining.model.JSON.UserInfo;
import com.mining.util.MiningConstants;

@Service("miningBO")
public class MiningBO {

	@Autowired
	private UserDAO userDAOImpl;
	
	final static Logger logger = LoggerFactory.getLogger(MiningBO.class);

	/**
	 * loginUser 
	 * 
	 * @param userInfo
	 * @return string
	 * @throws MiningException
	 */
	public String loginUser(UserInfo userInfo) throws MiningException {

		logger.debug("loginUser method starts");
		String res = MiningConstants.failed;
		UserInfo userInfoFromDB = userDAOImpl.loginUser(userInfo);
		// Checking null value
		if (userInfoFromDB != null && userInfo != null) {
			String userName = userInfoFromDB.getUserName();
			String password = userInfoFromDB.getPassword();
			if (userName.equals(userInfo.getUserName())
					&& password.equals(userInfo.getPassword())) {
				res = MiningConstants.success;
			}
		}
		logger.debug("loginUser method ends");
		return res;
	}

}
