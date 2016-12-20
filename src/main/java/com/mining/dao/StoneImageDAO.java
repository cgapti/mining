package com.mining.dao;

import com.mining.exception.MiningException;
import com.mining.model.StoneImage;

public interface StoneImageDAO {
	
	String saveStoneImage(StoneImage stoneImage)throws MiningException;

}
