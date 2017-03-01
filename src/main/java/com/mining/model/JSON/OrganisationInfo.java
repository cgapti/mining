package com.mining.model.JSON;

import java.io.Serializable;
import java.util.Date;


public class OrganisationInfo implements Serializable {

	
	private static final long serialVersionUID = 7403528816512781044L;
	private Integer organisationId;
	
	private String organisationName;
	
	private String location;
	
	private String organisationcontactNo;
	
	private String contactEmail;
	
	private String createdBy;
	
	private Date creationDate;
	
	private String address,organisationType;
	
	/**
	 * @return the organisationId
	 */
	public Integer getOrganisationId() {
		return organisationId;
	}
	/**
	 * @param organisationId the organisationId to set
	 */
	public void setOrganisationId(Integer organisationId) {
		this.organisationId = organisationId;
	}
	/**
	 * @return the organisationName
	 */
	public String getOrganisationName() {
		return organisationName;
	}
	/**
	 * @param organisationName the organisationName to set
	 */
	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the organisationcontactNo
	 */
	public String getOrganisationcontactNo() {
		return organisationcontactNo;
	}
	/**
	 * @param organisationcontactNo the organisationcontactNo to set
	 */
	public void setOrganisationcontactNo(String organisationcontactNo) {
		this.organisationcontactNo = organisationcontactNo;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the organisationType
	 */
	public String getOrganisationType() {
		return organisationType;
	}
	/**
	 * @param organisationType the organisationType to set
	 */
	public void setOrganisationType(String organisationType) {
		this.organisationType = organisationType;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
