package com.mining.dao.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mining.dao.AbstractDao;
import com.mining.dao.UserDAO;
import com.mining.exception.MiningException;
import com.mining.model.Organisation;
import com.mining.model.Status;
import com.mining.model.StoneImage;
import com.mining.model.User;
import com.mining.model.UserRoles;
import com.mining.model.JSON.StatusInfo;
import com.mining.model.JSON.StoneImageInfo;
import com.mining.model.JSON.UserApprovelInfo;
import com.mining.model.JSON.UserInfo;
import com.mining.util.MiningConstants;

@Repository("userDAOImpl")
public class UserDAOImpl extends AbstractDao<Integer, User> implements
		UserDAO {
	final static Logger logger = LoggerFactory
			.getLogger(UserDAOImpl.class);
	
	public String saveUser(User user) throws MiningException {
		logger.debug("saveUser method starts");
		saveOrUpdate(user);
		logger.debug("saveUser method ends");
		return MiningConstants.success;
	}

	/**
	 * loginUser
	 * 
	 */
	@SuppressWarnings("unchecked")
	public UserInfo loginUser(UserInfo userInfo) throws MiningException {/*
		logger.debug("loginUser method starts");
		UserInfo userInfoRes = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			String sql = "SELECT USER_NAME, USER_PASSWORD FROM TBL_USER_REGISTRATION WHERE USER_NAME= '"
					+ userInfo.getUserName() + "'";
			SQLQuery query = session.createSQLQuery(sql);
			List<Object[]> results = query.list();
			if (null != results && !results.isEmpty()) {
				userInfoRes = new UserInfo();
				Object[] row = results.get(0);
				userInfoRes.setUserName(row[0].toString());
				userInfoRes.setPassword(row[1].toString());
			}
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			logger.error(
					"Error occured while fetching the data from DB", e.getMessage());
			throw new MiningException(
					"Error occured while fetching the data from DB", e.getMessage());
		}
		logger.debug("loginUser method ends");
		return userInfoRes;
		*/
		logger.debug("loginUser method starts");
		UserInfo userInfoRes = null;
		Session session = null;
		Transaction trans = null;
		try {
			logger.debug("userInfo----"+userInfo);
			session = getSession();
			trans = session.beginTransaction();
			String sql = "FROM User WHERE userName= '"
					+ userInfo.getUserName() + "' and password='"+userInfo.getPassword()+"'";
			Query query = session.createQuery(sql);
			List<User> results = query.list();
			logger.debug("size of user details -->"+results.size());
			if (null != results && !results.isEmpty()) {
				for(User tempUser:results)
				{
					userInfoRes = new UserInfo();
					userInfoRes.setUserName(tempUser.getUserName());
					userInfoRes.setEmail(tempUser.getEmail());
				if(null!=tempUser.getOrg()){userInfoRes.setOrgName(tempUser.getOrg().getOrganisationName());}else{userInfoRes.setOrgName("");}
				if(null!=tempUser.getRoles()){userInfoRes.setRoleName(tempUser.getRoles().getUserRole());}else { userInfoRes.setRoleName("");}
				if(null!=tempUser.getUserStatus()){	userInfoRes.setStatusName(tempUser.getUserStatus().getStatus());} else {userInfoRes.setStatusName("");}
					userInfoRes.setPhoneNumber(tempUser.getPhoneNumber());
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
		logger.debug("loginUser method ends--->"+userInfoRes);
		return userInfoRes;
		}
	
	/**
	 * forgotPassword
	 * 
	 */
	@SuppressWarnings("unchecked")
	public UserInfo forgotPassword(UserInfo userInfo) throws MiningException {
		logger.debug("forgotPassword method starts");
		UserInfo userInfoRes = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			String sql = "SELECT USER_NAME, USER_PASSWORD FROM TBL_USER_REGISTRATION WHERE EMAIL= '"
					+ userInfo.getEmail() + "'";
			SQLQuery query = session.createSQLQuery(sql);
			List<Object[]> results = query.list();
			if (null != results && !results.isEmpty()) {
				userInfoRes = new UserInfo();
				Object[] row = results.get(0);
				userInfoRes.setUserName(row[0].toString());
				userInfoRes.setPassword(row[1].toString());
				userInfoRes.setEmail(userInfo.getEmail());
			}
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			logger.error(
					"Error occured while fetching the data from DB", e.getMessage());
			throw new MiningException(
					"Error occured while fetching the data from DB", e.getMessage());
		}
		logger.debug("forgotPassword method ends");
		return userInfoRes;
	}

	@SuppressWarnings("unchecked")
	public List<StoneImageInfo> getAllImages() throws MiningException {
		logger.debug("getAllImages method starts");
		List<StoneImageInfo> imageList = new ArrayList<StoneImageInfo>();
		Session session = null;
		Transaction trans = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			Query query = session.createQuery("from StoneImage");//here persistent class name is Emp  
			List<StoneImage> Querylist = query.list();
			if(null != Querylist) {
				for(StoneImage stoneImage : Querylist) {
					StoneImageInfo stoneImageInfo = new StoneImageInfo();
					stoneImageInfo.setImgeName(stoneImage.getImageName());
					stoneImageInfo.setImage(stoneImage.getImage());
					imageList.add(stoneImageInfo);
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
		logger.debug("getAllImages method ends");
		return imageList;
	}
    
	/**
	 * Method to get the URl from DB
	 */
	public String getServerUrl() throws MiningException {
		Session session = null;
		Transaction trans = null;
		String serverURL;
		try {
			session = getSession();
			trans = session.beginTransaction();
			String sql = "select url from server_url where application = 'Mining' and active = 'Y'";
			SQLQuery query = session.createSQLQuery(sql);
			serverURL = (String) query.list().get(0);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			logger.error("Error occured while fetching the data from DB", e.getMessage());
			throw new MiningException("Error occured while fetching the data from DB", e.getMessage());
		}
		logger.debug("getAllImages method ends");
		return serverURL;
	}

	
	private List<Status> getStatusById(Integer statusId) throws MiningException {
		
		logger.debug("getting status values Starts");
		Session session=null;
		Transaction trans=null;
		List<Status> statuslist=null;
		String queryStr="from Status ";
		try
		{
			session=getSession();
			trans=session.beginTransaction();
			if(statusId!=null)
			{
				queryStr+="where statusId = "+statusId;
			}
			statuslist=session.createQuery(queryStr).list();
			trans.commit();
			logger.debug("getting status Roles values ends");
		}
		catch(Exception e)
		{
			trans.rollback();
			logger.error("Error occured in Getting status Roles values "+e);
			throw new MiningException("Error occured in status  Roles values "+e);
		}
		return statuslist;
	}
	
	@Override
	public List<StatusInfo> getStatusValues(Integer statusId) throws MiningException {
		
		logger.debug("getting status values Starts");
		Session session=null;
		Transaction trans=null;
		List<StatusInfo> statusInfolist=new  ArrayList<StatusInfo>();
		String queryStr="from Status";
		try
		{
			session=getSession();
			trans=session.beginTransaction();
			List<Status> statuslist=session.createQuery(queryStr).list();
			if(null!=statuslist)
			{
				for(Status tempstatus:statuslist)
				{
					StatusInfo info=new StatusInfo();
					info.setStatusId(tempstatus.getStatusId());
					info.setStatus(tempstatus.getStatus());
					info.setStatusDesc(tempstatus.getStatusDesc());
					statusInfolist.add(info);
				}
			}
			trans.commit();
			logger.debug("getting status values ends");
		}
		catch(Exception e)
		{
			trans.rollback();
			logger.error("Error occured in Getting status  values "+e);
			throw new MiningException("Error occured in Getting status values "+e);
		}
		return statusInfolist;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<UserInfo> getPendingApprovels(String searchBy,String searchVal) throws MiningException {
		logger.debug("User DAO Impl pending Approvels Starts "+searchBy +"---"+searchVal);
		List<UserInfo> info=new ArrayList<UserInfo>();
		Session session=null;
		Transaction trans=null;
		try
		{
			//get organization List values
			Map<Integer,String> orgMap=getOrgList();
			Map<Integer,String> rolesMap=getRolesList();
			session = getSession();
			trans = session.beginTransaction();
			//Query query = session.createQuery("from User");
			Criteria cri=session.createCriteria(User.class,"user");
			cri.createAlias("user.roles", "roles",JoinType.LEFT_OUTER_JOIN);
			cri.createAlias("user.org", "org",JoinType.LEFT_OUTER_JOIN);
			cri.createAlias("user.userStatus", "status",JoinType.LEFT_OUTER_JOIN);
			if(null!=searchVal)
			{
				if(searchBy!=null)
				{
					switch(searchBy)
					{
						case "UserName":
						{
							cri.add(Restrictions.like("userName", "%"+searchVal+"%"));
							break;
						}
						case "PhoneNo":
						{
							cri.add(Restrictions.like("phoneNumber", "%"+searchVal+"%"));
							break;
						}
						case "Email":
						{
							cri.add(Restrictions.like("email", "%"+searchVal+"%"));
							break;
						}
						case "Role":
						{
							cri.add(Restrictions.like("roles.userRole", "%"+searchVal+"%"));
							break;
						}
						case "Organization":
						{
							cri.add(Restrictions.like("org.organisationName", "%"+searchVal+"%"));
							break;
						}
						
					}
				}
			}
			List<User> userList=cri.list();
			System.out.println("userList--size--"+userList.size());
			if(null!=userList)
			{
				for(User user:userList)
				{
					UserInfo tempinfo=new UserInfo();
					tempinfo.setUserId(user.getId());
					tempinfo.setUserName(user.getUserName());
					tempinfo.setPhoneNumber(user.getPhoneNumber());
					tempinfo.setEmail(user.getEmail());
					if(null!=user.getOrg()){tempinfo.setOrgId(user.getOrg().getOrganisationId());}
					if(null!=user.getRoles()){tempinfo.setRolesId(user.getRoles().getUserRolesId());}
					tempinfo.setRolesMap(rolesMap);
					if(null!=user.getUserStatus()){tempinfo.setStatusId(user.getUserStatus().getStatusId());}
					tempinfo.setOrgMap(orgMap);
					info.add(tempinfo);
				}
			}
			trans.commit();
			
		}
		catch(Exception e)
		{
			trans.rollback();
			logger.error("Error Occured in Pending approvels values Fetch "+e);
			throw new MiningException("Error Occured in Pending approvels values Fetch "+e);
		}
		logger.debug("User DAO Impl pending Approvels ends ");
		return info;
	}
	@SuppressWarnings("unchecked")
	private Map<Integer,String> getOrgList()throws MiningException
	{
		Map<Integer,String> orgMap=new HashMap<Integer, String>();
		Session session=null;
		Transaction trans=null;
		try
		{
			session = getSession();
			trans = session.beginTransaction();
			Query query = session.createQuery("from Organisation");
			List<Organisation> orgList=query.list();
			if(null!=orgList)
			{
				for(Organisation org:orgList)
				{
					orgMap.put(org.getOrganisationId(), org.getOrganisationName());
				}
			}
			trans.commit();
		}
		catch(Exception e)
		{
			trans.rollback();
			logger.error("Error Occured in org list values Fetch "+e);
			throw new MiningException("Error Occured in org list values Fetch "+e);
		}
		return orgMap;
	}
	@SuppressWarnings("unchecked")
	private Map<Integer,String> getRolesList()throws MiningException
	{
		Map<Integer,String> rolesMap=new HashMap<Integer, String>();
		Session session=null;
		Transaction trans=null;
		try
		{
			session = getSession();
			trans = session.beginTransaction();
			Query query = session.createQuery("from UserRoles");
			List<UserRoles> rolesList=query.list();
			if(null!=rolesList)
			{
				for(UserRoles roles:rolesList)
				{
					rolesMap.put(roles.getUserRolesId(), roles.getUserRole());
				}
			}
			trans.commit();
		}
		catch(Exception e)
		{
			trans.rollback();
			logger.error("Error Occured in org list values Fetch "+e);
			throw new MiningException("Error Occured in org list values Fetch "+e);
		}
		return rolesMap;
	}

	@Override
	public String saveUserApprovel(UserApprovelInfo appInfo)
			throws MiningException {
		Session session=null;
		Transaction trans=null;
		int totalSize=0,successSize=0;
		String returnMsg="";
		if(null!=appInfo)
		{
			if(null!=appInfo.getListInfo())
			{
				totalSize=appInfo.getListInfo().size();
				for(UserInfo  tempInfo:appInfo.getListInfo())
				{
					try
					{
						
						logger.debug("role Id --->"+tempInfo.getRolesId());
						UserRoles role=getUserRoles(tempInfo.getRolesId());
						logger.debug("After loading UserRoles---"+role);
						logger.debug("Organization Id ===>"+tempInfo.getOrgId());
						//Organization org=(Organization)session.load(Organization.class, tempInfo.getOrgId());
						Organisation org=getOrganisation(tempInfo.getOrgId());
						logger.debug("After loading Organization---"+org);
						Status status=getStatusById(tempInfo.getStatusId()).get(0);
						session=getSession();
						trans=session.beginTransaction();
						logger.debug("User Id ---"+tempInfo.getUserId());
						User user=(User)session.load(User.class, tempInfo.getUserId());
						logger.debug("user---"+user);
						user.setOrg(org);
						user.setUserStatus(status);
						user.setRoles(role);
						session.update(user);
						trans.commit();
						successSize++;
					}
					catch(Exception e)
					{
						if(trans.isActive())
							trans.rollback();
						logger.error("error saving Approvel details of user "+tempInfo.getUserName()+" in UserDAOImpl :"+e);
					}
				}
			}
		}
		returnMsg="Sucessfully Updated User details : "+successSize+ " out of "+totalSize;
		return returnMsg;
	}
	private Organisation getOrganisation(Integer orgId) throws MiningException
	{
		logger.debug("getting organization values Starts");
		Session session=null;
		Transaction trans=null;
		Organisation org=null;
		try
		{
			session=getSession();
			trans=session.beginTransaction();
			org=(Organisation) session.get(Organisation.class, orgId);
			trans.commit();
			logger.debug("getting organization values ends");
		}
		catch(Exception e)
		{
			trans.rollback();
			logger.error("Error occured in Getting Organization values "+e);
			throw new MiningException("Error occured in Getting Organization values "+e);
		}
		return org;
	}
	private UserRoles getUserRoles(Integer roleId) throws MiningException
	{
		logger.debug("getting User Roles values Starts");
		Session session=null;
		Transaction trans=null;
		UserRoles roles=null;
		try
		{
			session=getSession();
			trans=session.beginTransaction();
			roles=(UserRoles) session.get(UserRoles.class, roleId);
			trans.commit();
			logger.debug("getting User Roles values ends");
		}
		catch(Exception e)
		{
			trans.rollback();
			logger.error("Error occured in Getting User Roles values "+e);
			throw new MiningException("Error occured in Getting User Roles values "+e);
		}
		return roles;
	}

	
	
	
	
}
