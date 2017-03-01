package com.mining.dao;

import java.util.List;

import com.mining.exception.MiningException;
import com.mining.model.Organisation;
import com.mining.model.JSON.OrganisationInfo;

public interface OrganisationDAO {
	public String saveOrganisation(Organisation org)throws MiningException;
	public List<OrganisationInfo> organisationList()throws MiningException;
	public String deleteOrganisation(Integer orgId)throws MiningException;
}
