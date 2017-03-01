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
@Table(name="TBL_STATUS")
public class Status implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2257169678051527369L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="status_seq")
	@SequenceGenerator(name="status_seq",sequenceName="status_statusid_seq",allocationSize=1)
	@Column(name="STATUS_ID")
	private Integer statusId;
	@NotEmpty
	@Column(name="STATUS_NAME")
	private String status;
	@Column(name="STATUS_DESC")
	private String statusDesc;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the statusDesc
	 */
	public String getStatusDesc() {
		return statusDesc;
	}
	/**
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	
}
