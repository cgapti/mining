package com.mining.service;

import java.util.List;

import com.mining.exception.MiningException;
import com.mining.model.JSON.OrganisationInfo;

public interface OrganisationService {
	public String saveOrganisation(OrganisationInfo org)throws MiningException;
	public List<OrganisationInfo> organisationList()throws MiningException;
	public String deleteOrganization(Integer orgId)throws MiningException;
}
