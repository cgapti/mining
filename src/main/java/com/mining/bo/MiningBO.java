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
		logger.debug("userInfoFromDB---"+userInfoFromDB.getStatusName()+"--"+userInfoFromDB.getOrgName() +"---"+userInfoFromDB.getRoleName());
		if(null!=userInfoFromDB)
		{
			if(!userInfoFromDB.getStatusName().equals("") && !("").equals(userInfoFromDB.getOrgName()) &&  !("").equals(userInfoFromDB.getRoleName()))
			{
				if("Pending".equals(userInfoFromDB.getStatusName()))
				{
					res="User is in Pending Status";
				}
				else if("Inactive".equals(userInfoFromDB.getStatusName()))
				{
					res="User is in Inactive Status";
				}
				else if("Active".equals(userInfoFromDB.getStatusName()))
				{
					res="Active User$$$"+userInfoFromDB.getEmail()+"$$$"+userInfoFromDB.getOrgName()+"$$$"+userInfoFromDB.getRoleName();
				}
			}
			else
			{
				res="User is in Pending Status";
			}
		}
		logger.debug("loginUser method ends");
		return res;
	}

}
