package com.mining.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mining.dao.UserRolesDAO;
import com.mining.exception.MiningException;
import com.mining.model.UserRoles;
import com.mining.model.JSON.UserRolesInfo;
import com.mining.service.UserRolesService;

@Service("UserRolesServiceImpl")
public class UserRolesServiceImpl implements UserRolesService{

	@Autowired
	private UserRolesDAO userRolesDAOImpl;
	@Override
	public List<UserRolesInfo> getUserRoles() throws MiningException {
		
		return userRolesDAOImpl.getUserRoles();
	}
	@Override
	public String saveUserRoles(UserRolesInfo info) throws MiningException {
		if(info!=null)
		{
			return  userRolesDAOImpl.saveUserRoles(convertInfotoPOJO(info));
		}
		return null;
	}
	private UserRoles convertInfotoPOJO(UserRolesInfo info)
	{
		UserRoles roles=new  UserRoles();
		if(info!=null)
		{
			if(info.getUserRolesId()!=null){roles.setUserRolesId(info.getUserRolesId());}
			roles.setUserRole(info.getUserRole());
			roles.setRoleDescription(info.getRoleDescription());
		}
		return roles;
	}

}
