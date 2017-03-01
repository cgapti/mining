package com.mining.service;

import java.util.List;

import com.mining.exception.MiningException;
import com.mining.model.JSON.UserRolesInfo;

public interface UserRolesService {
	public String saveUserRoles(UserRolesInfo info)throws MiningException;
	public List<UserRolesInfo> getUserRoles()throws MiningException;
}
