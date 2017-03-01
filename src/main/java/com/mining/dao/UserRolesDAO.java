package com.mining.dao;

import java.util.List;

import com.mining.exception.MiningException;
import com.mining.model.UserRoles;
import com.mining.model.JSON.UserRolesInfo;

public interface UserRolesDAO {
	public String saveUserRoles(UserRoles info)throws MiningException;
	public List<UserRolesInfo> getUserRoles()throws MiningException;
}
