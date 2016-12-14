package com.mining.service;

import com.mining.exception.MiningException;
import com.mining.model.JSON.UserInfo;

public interface UserService {
	
	String saveUser(UserInfo userInfo)throws MiningException;

	String loginUser(UserInfo user)throws MiningException;

}
