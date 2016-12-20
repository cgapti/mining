package com.mining.model.JSON;

import java.io.Serializable;

public class StoneImageInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7639326673869275255L;
	
	private String imgeName;
	private byte[] image;

	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

	/**
	 * @return the imgeName
	 */
	public String getImgeName() {
		return imgeName;
	}

	/**
	 * @param imgeName the imgeName to set
	 */
	public void setImgeName(String imgeName) {
		this.imgeName = imgeName;
	}
}
