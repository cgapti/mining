package com.mining.model.JSON;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8186727015881476248L;
	
	private Integer userId;
	
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	private String userName;

	private String password;

	private String phoneNumber;

	private String email;

	private String role;
	
	private Integer orgId;
	
	private Integer rolesId;
	
	private Map<Integer, String> orgMap=new HashMap<Integer, String>();
	
	private String userStatus;
	
	private Map<Integer, String> rolesMap=new HashMap<Integer, String>();

	private Integer statusId;
	
	private String orgName,roleName,statusName;
	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the statusName
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * @param statusName the statusName to set
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * @return the statusId
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the orgId
	 */
	public Integer getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	/**
	 * @return the rolesId
	 */
	public Integer getRolesId() {
		return rolesId;
	}

	/**
	 * @param rolesId the rolesId to set
	 */
	public void setRolesId(Integer rolesId) {
		this.rolesId = rolesId;
	}

	

	
	/**
	 * @return the orgMap
	 */
	public Map<Integer, String> getOrgMap() {
		return orgMap;
	}

	/**
	 * @param orgMap the orgMap to set
	 */
	public void setOrgMap(Map<Integer, String> orgMap) {
		this.orgMap = orgMap;
	}

	/**
	 * @return the rolesMap
	 */
	public Map<Integer, String> getRolesMap() {
		return rolesMap;
	}

	/**
	 * @param rolesMap the rolesMap to set
	 */
	public void setRolesMap(Map<Integer, String> rolesMap) {
		this.rolesMap = rolesMap;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	

	/**
	 * @return the userStatus
	 */
	public String getUserStatus() {
		return userStatus;
	}

	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

}
