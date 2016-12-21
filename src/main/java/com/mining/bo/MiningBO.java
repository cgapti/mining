package com.mining.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mining.dao.UserDAO;
import com.mining.exception.MiningException;
import com.mining.model.JSON.UserInfo;

@Service("miningBO")
public class MiningBO {

	@Autowired
	private UserDAO userDAOImpl;

	public String loginUser(UserInfo userInfo) throws MiningException {

		System.out.println("MiningDAOImpl - saveUser method starts");
		String res = "failed";
		UserInfo userInfoFromDB = userDAOImpl.loginUser(userInfo);
		// Checking null value
		if (userInfoFromDB != null && userInfo != null) {
			String userName = userInfoFromDB.getUserName();
			String password = userInfoFromDB.getPassword();
			if (userName.equals(userInfo.getUserName())
					&& password.equals(userInfo.getPassword())) {
				res = "success";
			}
		}
		System.out.println("MiningDAOImpl - saveUser method starts");
		return res;
	}

}
