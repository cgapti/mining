package com.mining.dao.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mining.dao.AbstractDao;
import com.mining.dao.StoneImageDAO;
import com.mining.exception.MiningException;
import com.mining.model.StoneImage;
import com.mining.util.MiningConstants;

@Repository("stoneImageDAOImpl")
public class StoneImageDAOImpl extends AbstractDao<Integer, StoneImage>
		implements StoneImageDAO {
	final static Logger logger = LoggerFactory
			.getLogger(StoneImageDAOImpl.class);

	/**
	 * saveStoneImage
	 * 
	 */
	public String saveStoneImage(StoneImage stoneImage) throws MiningException {
		logger.debug("saveStoneImage method starts");
		saveOrUpdate(stoneImage);
		logger.debug("saveStoneImage method ends");
		return MiningConstants.success;
	}

}
