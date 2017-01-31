package com.mining.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mining.dao.AbstractDao;
import com.mining.dao.StoneDAO;
import com.mining.exception.MiningException;
import com.mining.model.Stone;
import com.mining.model.StoneImage;
import com.mining.model.JSON.StoneImageInfo;
import com.mining.model.JSON.StoneInfo;
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

	@SuppressWarnings("unchecked")
	public List<StoneInfo> getStoneDetails() throws MiningException {
		logger.debug("getStoneDetails method starts");
		List<StoneInfo> stoneList = new ArrayList<StoneInfo>();
		Session session = null;
		Transaction trans = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			Query query = session.createQuery("from Stone");
			List<Stone> Querylist = query.list();
			if(null != Querylist) {
				for(Stone stone : Querylist) {
					StoneInfo stoneInfo = new StoneInfo();
					stoneInfo.setHeight(stone.getHeight());
					stoneInfo.setLength(stone.getLength());
					stoneInfo.setColour(stone.getColour());
					stoneInfo.setType(stone.getType());
					stoneInfo.setQuantity(stone.getQuantity());
					stoneInfo.setWidth(stone.getWidth());
					stoneList.add(stoneInfo);
				}
			}			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			logger.error(
					"Error occured while fetching the data from DB", e.getMessage());
			throw new MiningException(
					"Error occured while fetching the data from DB", e.getMessage());
		}
		logger.debug("getStoneDetails method ends");
		return stoneList;
	}

}
