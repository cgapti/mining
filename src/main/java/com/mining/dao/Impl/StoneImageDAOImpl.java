package com.mining.dao.Impl;

import org.springframework.stereotype.Repository;

import com.mining.dao.AbstractDao;
import com.mining.dao.StoneImageDAO;
import com.mining.exception.MiningException;
import com.mining.model.StoneImage;

@Repository("stoneImageDAOImpl")
public class StoneImageDAOImpl extends AbstractDao<Integer, StoneImage>
		implements StoneImageDAO {

	public String saveStoneImage(StoneImage stoneImage) throws MiningException {
		System.out.println("StoneImageDAOImpl - saveStoneImage method starts");
		saveOrUpdate(stoneImage);
		System.out.println("StoneImageDAOImpl - saveStoneImage method starts");
		return "success";
	}

}
