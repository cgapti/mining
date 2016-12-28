package com.mining.dao.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mining.dao.AbstractDao;
import com.mining.dao.StoneDAO;
import com.mining.exception.MiningException;
import com.mining.model.Stone;
import com.mining.util.MiningConstants;

@Repository("stoneDAOImpl")
public class StoneDAOImpl extends AbstractDao<Integer, Stone> implements
		StoneDAO {
	final static Logger logger = LoggerFactory
			.getLogger(StoneDAOImpl.class);

	/**
	 * saveStoneDetails
	 * 
	 */
	public String saveStoneDetails(Stone stone) throws MiningException {
		logger.debug("saveStoneDetails method starts");
		saveOrUpdate(stone);
		logger.debug("saveStoneDetails method ends");
		return MiningConstants.success;
	}

}
