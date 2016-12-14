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

@Entity
@Table(name = "TBL_STONE_DETAILS")
public class Stone implements Serializable {

	private static final long serialVersionUID = -6701297143234634029L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stn_dtl_seq")
	@SequenceGenerator(name = "stn_dtl_seq", sequenceName = "STN_DTL_SLNO_SEQ", allocationSize = 1)
	@Column(name = "STONE_SLNO")
	private Integer sID;

	@NotNull
	@Column(name = "STONE_WIDTH")
	private Double width;

	@NotNull
	@Column(name = "STONE_HEIGHT")
	private Double height;

	@NotNull
	@Column(name = "STONE_LENGTH")
	private Double length;

	@NotNull
	@Column(name = "STONE_TYPE")
	private String type;

	@NotNull
	@Column(name = "STONE_COLOUR")
	private String colour;

	@NotNull
	@Column(name = "STONE_QTY")
	private Integer quantity;

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
	 * @return the width
	 */
	public Double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(Double width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public Double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(Double height) {
		this.height = height;
	}

	/**
	 * @return the length
	 */
	public Double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(Double length) {
		this.length = length;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the sID
	 */
	public Integer getsID() {
		return sID;
	}

	/**
	 * @param sID the sID to set
	 */
	public void setsID(Integer sID) {
		this.sID = sID;
	}

}
