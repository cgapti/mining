package com.mining.service.Impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mining.dao.OrganisationDAO;
import com.mining.exception.MiningException;
import com.mining.model.Organisation;
import com.mining.model.JSON.OrganisationInfo;
import com.mining.service.OrganisationService;

@Service("organisationServiceImpl")
public class OrganisationServiceImpl implements OrganisationService{
	@Autowired
	private OrganisationDAO orgdaoImpl;
	final static Logger logger = LoggerFactory
			.getLogger(OrganisationServiceImpl.class);
	@Override
	public String saveOrganisation(OrganisationInfo org) throws MiningException {
		logger.debug("OrganizationServiceImpl save organization starts");
		return orgdaoImpl.saveOrganisation(convertInfotoPOJO(org));
	}

	@Override
	public List<OrganisationInfo> organisationList() throws MiningException {
		return orgdaoImpl.organisationList();
	}

	@Override
	public String deleteOrganization(Integer orgId) throws MiningException {
		return null;
	}
	private Organisation convertInfotoPOJO(OrganisationInfo info)throws MiningException
	{
		logger.debug("OrganizationServiceImpl : convert info to pojo starts");
		Organisation org=new Organisation();
		if(info!=null)
		{
			if(info.getOrganisationId()!=null){org.setOrganisationId(info.getOrganisationId());}
			org.setOrganisationName(info.getOrganisationName());
			org.setLocation(info.getLocation());
			org.setOrganisationcontactNo(info.getOrganisationcontactNo());
			org.setContactEmail(info.getContactEmail());
			org.setAddress(info.getAddress());
			org.setOrganisationType(info.getOrganisationType());
			org.setCreatedBy("Admin");
			org.setCreationDate(new Date());
		}
		logger.debug("OrganizationServiceImpl : convert info to pojo ends");
		return org;
	}
}
