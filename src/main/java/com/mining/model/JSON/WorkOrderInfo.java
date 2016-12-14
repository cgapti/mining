package com.mining.model.JSON;

import java.io.Serializable;

public class WorkOrderInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6943305886499794597L;

	private String empName;

	private String timeIN;

	private String timeOUT;

	private String workedHours;

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName
	 *            the empName to set
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
	 * @param timeIN
	 *            the timeIN to set
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
	 * @param timeOUT
	 *            the timeOUT to set
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
	 * @param workedHours
	 *            the workedHours to set
	 */
	public void setWorkedHours(String workedHours) {
		this.workedHours = workedHours;
	}

}
