package com.mining.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="TBL_USER_ROLES")
public class UserRoles implements Serializable 
{
	
	private static final long serialVersionUID = -5944762561149589313L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_roles_seq")
	@SequenceGenerator(name="user_roles_seq",sequenceName="user_roles_slno_seq",allocationSize=1)
	@Column(name="USER_ROLES_ID")
	private Integer userRolesId;
	
	@NotEmpty
	@Column(name="USER_ROLE_NAME")
	private String userRole;
	@Column(name="USER_ROLE_DESC")
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
