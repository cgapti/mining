package com.mining.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="TBL_ORGANISATION")
public class Organisation implements Serializable {

	
	private static final long serialVersionUID = 7403528816512781044L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="organisation_seq")
	@SequenceGenerator(name = "organisation_seq", sequenceName = "organisation_slno_seq", allocationSize = 1)
	@Column(name="ORGANISATION_ID")
	private Integer organisationId;
	
	@NotEmpty
	@Column(name="ORGANISATION_NAME")
	private String organisationName;
	
	@NotEmpty
	@Column(name="ORGANISATION_LOCATION")
	private String location;
	
	@NotEmpty
	@Column(name="ORGANISATION_CONTACTNO")
	private String organisationcontactNo;
	
	@NotEmpty
	@Column(name="ORGANISATION_CONTACTEMAIL")
	private String contactEmail;
	
	@NotEmpty
	@Column(name="ADDRESS")
	private String address;
	@NotEmpty
	@Column(name="ORGANISATION_TYPE")
	private String organisationType;
	
	@NotEmpty
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@NotNull
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

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
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * @param contactEmail the contactEmail to set
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
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

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
}
