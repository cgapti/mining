package com.mining.dao;

import com.mining.exception.MiningException;
import com.mining.model.User;
import com.mining.model.JSON.UserInfo;

public interface UserDAO {
	
	String saveUser(User user)throws MiningException;
	UserInfo loginUser(UserInfo userInfo)throws MiningException;
	

}
