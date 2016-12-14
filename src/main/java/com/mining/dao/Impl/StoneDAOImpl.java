package com.mining.dao.Impl;

import org.springframework.stereotype.Repository;

import com.mining.dao.AbstractDao;
import com.mining.dao.StoneDAO;
import com.mining.exception.MiningException;
import com.mining.model.Stone;

@Repository("stoneDAOImpl")
public class StoneDAOImpl extends AbstractDao<Integer, Stone> implements
		StoneDAO {

	public String saveStoneDetails(Stone stone) throws MiningException {
		System.out.println("WorkOrderDAOImpl - saveUser method starts");
		saveOrUpdate(stone);
		System.out.println("MiningDAOImpl - saveUser method starts");
		return "success";
	}

}
