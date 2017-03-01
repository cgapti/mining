package com.mining.model.JSON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserApprovelInfo implements Serializable
{
	private static final long serialVersionUID = -577811197287782057L;
	private List<UserInfo> listInfo=new ArrayList<UserInfo>();
	/**
	 * @return the listInfo
	 */
	public List<UserInfo> getListInfo() {
		return listInfo;
	}
	/**
	 * @param listInfo the listInfo to set
	 */
	public void setListInfo(List<UserInfo> listInfo) {
		this.listInfo = listInfo;
	}
	
}
