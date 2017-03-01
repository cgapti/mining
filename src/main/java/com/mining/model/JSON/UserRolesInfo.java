package com.mining.model.JSON;

import java.io.Serializable;



public class UserRolesInfo implements Serializable 
{
	
	private static final long serialVersionUID = -5944762561149589313L;

	private Integer userRolesId;
	private String userRole;
	private String roleDescription;
	public Integer getUserRolesId() {
		return userRolesId;
	}
	public void setUserRolesId(Integer userRolesId) {
		this.userRolesId = userRolesId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

}
