package com.mining.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "TBL_USER_REGISTRATION")
public class User implements Serializable {

	private static final long serialVersionUID = 5260911419190249826L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "user_empslno_seq", allocationSize = 1)
	@Column(name = "EMP_SRL_NUM")
	private Integer id;

	@NotEmpty
	@Column(name = "USER_NAME")
	private String userName;

	@NotEmpty
	@Column(name = "USER_PASSWORD")
	private String password;

	@NotEmpty
	@Column(name = "MOBILE")
	private String phoneNumber;

	@NotEmpty
	@Column(name = "EMAIL")
	private String email;

	@NotEmpty
	@Column(name = "USER_ROLE")
	private String role;

	@NotNull
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@OneToOne
	@JoinColumn(name="ORG_ID")
	private Organisation org;
	@OneToOne
	@JoinColumn(name="ROLES_ID")
	private UserRoles roles;
	
	@OneToOne
	@JoinColumn(name="STATUS_ID")
	private Status userStatus;
	
	
	
	/**
	 * @return the userStatus
	 */
	public Status getUserStatus() {
		return userStatus;
	}

	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(Status userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
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
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the org
	 */
	public Organisation getOrg() {
		return org;
	}

	/**
	 * @param org the org to set
	 */
	public void setOrg(Organisation org) {
		this.org = org;
	}

	/**
	 * @return the roles
	 */
	public UserRoles getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(UserRoles roles) {
		this.roles = roles;
	}
	
}
