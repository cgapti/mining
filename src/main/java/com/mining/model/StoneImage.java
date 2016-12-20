package com.mining.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "TBL_STONE_IMAGES")
public class StoneImage implements Serializable {

	private static final long serialVersionUID = 8704535406621494434L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stn_image_seq")
	@SequenceGenerator(name = "stn_image_seq", sequenceName = "STN_IMG_SLNO_SEQ", allocationSize = 1)
	@Column(name = "IMAGE_SLNO")
	private Integer imageID;

	@NotEmpty
	@Column(name = "IMAGE_FILE")
	private String imageName;
	
	@Lob
	@Column(name = "STONE_IMAGE", columnDefinition = "VARBINARY")
	private byte[] image;

	@NotNull
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	/**
	 * @return the imageID
	 */
	public Integer getImageID() {
		return imageID;
	}

	/**
	 * @param imageID
	 *            the imageID to set
	 */
	public void setImageID(Integer imageID) {
		this.imageID = imageID;
	}

	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
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
	 * @return the imageName
	 */
	public String getImageName() {
		return imageName;
	}

	/**
	 * @param imageName the imageName to set
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}
