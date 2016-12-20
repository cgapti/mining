package com.mining.service.Impl;

import java.util.Date;

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

	public String saveStoneDetails(StoneInfo stoneInfo)
			throws MiningException {
		System.out.println("StoneServiceImpl - saveWorkOrder method starts");
		System.out.println("StoneServiceImpl - saveWorkOrder method ends");
		return StoneDAOImpl.saveStoneDetails(processStoneInfo(stoneInfo));
	}

	private Stone processStoneInfo(StoneInfo stoneInfo) {
		System.out.println("StoneServiceImpl - processStoneInfo method starts");
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
		System.out.println("StoneServiceImpl - processStoneInfo method Ends");
		return stone;
	}

	public String saveStoneImage(StoneImageInfo stoneImageInfo)
			throws MiningException {		
		System.out.println("StoneServiceImpl - saveStoneImage method starts");
		System.out.println("StoneServiceImpl - saveStoneImage method ends");
		return stoneImageDAOImpl.saveStoneImage(processStoneImageInfo(stoneImageInfo));
	}

	private StoneImage processStoneImageInfo(StoneImageInfo stoneImageInfo) {
		
		System.out.println("StoneServiceImpl - processStoneImageInfo method starts");
		StoneImage stoneImage = new StoneImage();
		if (null != stoneImageInfo) {
			stoneImage.setImageName(stoneImageInfo.getImgeName());
			stoneImage.setImage(stoneImage.getImage());			
			stoneImage.setCreationDate(new Date());
		}
		System.out.println("StoneServiceImpl - processStoneImageInfo method Ends");
		return stoneImage;
	}

}
