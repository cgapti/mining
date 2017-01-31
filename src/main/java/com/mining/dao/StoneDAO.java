package com.mining.dao;

import java.util.List;

import com.mining.exception.MiningException;
import com.mining.model.Stone;
import com.mining.model.JSON.StoneInfo;

public interface StoneDAO {
	
	String saveStoneDetails(Stone stone)throws MiningException;
	List<StoneInfo> getStoneDetails()throws MiningException;

}
