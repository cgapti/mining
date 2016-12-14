package com.mining.dao;

import com.mining.exception.MiningException;
import com.mining.model.Stone;

public interface StoneDAO {
	
	String saveStoneDetails(Stone stone)throws MiningException;
	

}
