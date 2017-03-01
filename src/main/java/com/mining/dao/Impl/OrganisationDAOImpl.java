package com.mining.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mining.dao.AbstractDao;
import com.mining.dao.OrganisationDAO;
import com.mining.exception.MiningException;
import com.mining.model.Organisation;
import com.mining.model.JSON.OrganisationInfo;
import com.mining.util.MiningConstants;

@Repository("organisationDAOImpl")
public class OrganisationDAOImpl  extends AbstractDao<Integer, Organisation> implements OrganisationDAO{

	final static Logger logger = LoggerFactory
			.getLogger(OrganisationDAOImpl.class);
	@Override
	public String saveOrganisation(Organisation org) throws MiningException {
		logger.debug("Organization save part starts");
		saveOrUpdate(org);
		logger.debug("Organization save part ends");
		return MiningConstants.success;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<OrganisationInfo> organisationList() throws MiningException {
		logger.debug("Organization get list of values starts");
		List<OrganisationInfo> listOrg=new ArrayList<OrganisationInfo>();
		Session session=null;
		Transaction tran=null;
		try
		{
			session=getSession();
			tran=session.beginTransaction();
			logger.debug("before call critera ***********");
			Criteria cri=session.createCriteria(Organisation.class);
			List<Organisation> orglist=cri.list();
			logger.debug("orglist---"+orglist);
			if(orglist!=null)
			{
				for(Organisation org:orglist)
				{
					OrganisationInfo orgtemp=new OrganisationInfo();
					orgtemp.setOrganisationId(org.getOrganisationId());
					orgtemp.setOrganisationName(org.getOrganisationName());
					orgtemp.setLocation(org.getLocation());
					orgtemp.setOrganisationcontactNo(org.getOrganisationcontactNo());
					orgtemp.setContactEmail(org.getContactEmail());
					orgtemp.setAddress(org.getAddress());
					orgtemp.setOrganisationType(org.getOrganisationType());
					orgtemp.setCreatedBy(org.getCreatedBy());
					orgtemp.setCreationDate(org.getCreationDate());
					listOrg.add(orgtemp);
				}
			}
		}
		catch(Exception e)
		{
			tran.rollback();
			logger.error("e---"+e);
			logger.error("Error occured while fetching the org data from DB", e.getMessage());
			throw new MiningException(
					"Error occured while fetching the org data from DB", e.getMessage());
		}
		logger.debug("Organization get list of values ends");
		return listOrg;
	}

	@Override
	public String deleteOrganisation(Integer orgId) throws MiningException {
		return null;
	}

}
