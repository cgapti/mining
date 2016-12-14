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
@Table(name = "TBL_WORK_ORDER")
public class WorkOrder implements Serializable {

	private static final long serialVersionUID = 3616969202132843830L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wrk_odr_seq")
	@SequenceGenerator(name = "wrk_odr_seq", sequenceName = "WRK_ODR_SLNO_SEQ", allocationSize = 1)
	@Column(name = "WRK_ODR_SLNO")
	private Integer workID;

	@NotEmpty
	@Column(name = "EMP_NAME")
	private String empName;

	@NotEmpty
	@Column(name = "TIME_IN")
	private String timeIN;

	@NotEmpty
	@Column(name = "TIME_OUT")
	private String timeOUT;

	@NotEmpty
	@Column(name = "WORKED_HRS")
	private String workedHours;

	@NotNull
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(name = "CREATED_BY")
	private String createdBy;


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
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the timeIN
	 */
	public String getTimeIN() {
		return timeIN;
	}

	/**
	 * @param timeIN the timeIN to set
	 */
	public void setTimeIN(String timeIN) {
		this.timeIN = timeIN;
	}

	/**
	 * @return the timeOUT
	 */
	public String getTimeOUT() {
		return timeOUT;
	}

	/**
	 * @param timeOUT the timeOUT to set
	 */
	public void setTimeOUT(String timeOUT) {
		this.timeOUT = timeOUT;
	}

	/**
	 * @return the workedHours
	 */
	public String getWorkedHours() {
		return workedHours;
	}

	/**
	 * @param workedHours the workedHours to set
	 */
	public void setWorkedHours(String workedHours) {
		this.workedHours = workedHours;
	}

	/**
	 * @return the workID
	 */
	public Integer getWorkID() {
		return workID;
	}

	/**
	 * @param workID the workID to set
	 */
	public void setWorkID(Integer workID) {
		this.workID = workID;
	}

}
