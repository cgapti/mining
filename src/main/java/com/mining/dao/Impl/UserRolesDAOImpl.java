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
import com.mining.dao.UserRolesDAO;
import com.mining.exception.MiningException;
import com.mining.model.UserRoles;
import com.mining.model.JSON.UserRolesInfo;
import com.mining.util.MiningConstants;

@Repository("UserRolesDAOImpl")
public class UserRolesDAOImpl extends AbstractDao<Integer, UserRoles> implements UserRolesDAO {

	final static Logger logger = LoggerFactory
			.getLogger(UserRolesDAOImpl.class);
	@Override
	@SuppressWarnings("unchecked")
	public List<UserRolesInfo> getUserRoles() throws MiningException {
		logger.debug("UserRolesDAOImpl get list of values starts");
		List<UserRolesInfo> listUserroles=new ArrayList<UserRolesInfo>();
		Session session=null;
		Transaction tran=null;
		try
		{
			session=getSession();
			tran=session.beginTransaction();
			Criteria cri=session.createCriteria(UserRoles.class);
			
			List<UserRoles> roleslist=cri.list();
			if(roleslist!=null)
			{
				for(UserRoles roles:roleslist)
				{
					UserRolesInfo rolestemp=new UserRolesInfo();
					rolestemp.setUserRolesId(roles.getUserRolesId());
					rolestemp.setUserRole(roles.getUserRole());
					rolestemp.setRoleDescription(roles.getRoleDescription());
					listUserroles.add(rolestemp);
				}
			}
		}
		catch(Exception e)
		{
			tran.rollback();
			logger.error("Error occured while fetching the user roles data from DB", e.getMessage());
			throw new MiningException(
					"Error occured while fetching the user roles from DB", e.getMessage());
		}
		logger.debug("user roles get list of values ends");
		return listUserroles;
	}
	@Override
	public String saveUserRoles(UserRoles info) throws MiningException {
		logger.debug("DAO Impl user roles save starts");
		saveOrUpdate(info);
		logger.debug("DAO Impl user roles save ends");
		return MiningConstants.success;
	}

}
