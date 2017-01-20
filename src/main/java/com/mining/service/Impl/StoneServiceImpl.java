package com.mining.service.Impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mining.dao.StoneDAO;
import com.mining.dao.StoneImageDAO;
import com.mining.exception.MiningException;
import com.mining.model.Stone;
import com.mining.model.StoneImage;
import com.mining.model.JSON.StoneImageInfo;
import com.mining.model.JSON.StoneInfo;
import com.mining.service.StoneService;

@Service("stoneServiceImpl")
public class StoneServiceImpl implements StoneService {

	@Autowired
	private StoneDAO StoneDAOImpl;
	@Autowired
	private StoneImageDAO stoneImageDAOImpl;

	final static Logger logger = LoggerFactory
			.getLogger(StoneServiceImpl.class);

	/**
	 * saveStoneDetails
	 * 
	 */
	public String saveStoneDetails(StoneInfo stoneInfo) throws MiningException {
		logger.debug("saveStoneDetails method starts");
		logger.debug("saveStoneDetails method ends");
		return StoneDAOImpl.saveStoneDetails(processStoneInfo(stoneInfo));
	}

	/**
	 * processStoneInfo
	 * 
	 */
	private Stone processStoneInfo(StoneInfo stoneInfo) {
		logger.debug("processStoneInfo method starts");
		Stone stone = new Stone();
		if (null != stoneInfo) {
			stone.setWidth(stoneInfo.getWidth());
			stone.setHeight(stoneInfo.getHeight());
			stone.setLength(stoneInfo.getLength());
			stone.setType(stoneInfo.getType());
			stone.setColour(stoneInfo.getColour());
			stone.setQuantity(stoneInfo.getQuantity());
			stone.setCreationDate(new Date());
		}
		logger.debug("processStoneInfo method ends");
		return stone;
	}

	/**
	 * saveStoneImage
	 * 
	 */
	public String saveStoneImage(StoneImageInfo stoneImageInfo)
			throws MiningException {
		logger.debug("saveStoneImage method starts");
		logger.debug("saveStoneImage method ends");
		return stoneImageDAOImpl
				.saveStoneImage(processStoneImageInfo(stoneImageInfo));
	}

	private StoneImage processStoneImageInfo(StoneImageInfo stoneImageInfo) {
		logger.debug("processStoneImageInfo method starts");
		StoneImage stoneImage = new StoneImage();
		if (null != stoneImageInfo) {
			stoneImage.setImageName(stoneImageInfo.getImgeName());
			stoneImage.setImage(stoneImageInfo.getImage());
			stoneImage.setCreationDate(new Date());
		}
		logger.debug("processStoneImageInfo method ends");
		return stoneImage;
	}

}
