package com.mining.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mining.bo.MiningBO;
import com.mining.exception.MiningException;
import com.mining.model.JSON.OrganisationInfo;
import com.mining.model.JSON.StatusInfo;
import com.mining.model.JSON.StoneImageInfo;
import com.mining.model.JSON.StoneInfo;
import com.mining.model.JSON.UserApprovelInfo;
import com.mining.model.JSON.UserInfo;
import com.mining.model.JSON.UserRolesInfo;
import com.mining.model.JSON.WorkOrderInfo;
import com.mining.service.OrganisationService;
import com.mining.service.StoneService;
import com.mining.service.UserRolesService;
import com.mining.service.UserService;
import com.mining.service.WorkOrderService;
import com.mining.util.MiningConstants;

@RestController
@RequestMapping(value = "/ms")
public class MiningRestController {

	@Autowired
	private UserService userServiceImpl;
	
	@Autowired
	private WorkOrderService workOrderServiceImpl;
	
	@Autowired
	private StoneService stoneServiceImpl;
	
	@Autowired
	private OrganisationService organisationServiceImpl;

	@Autowired
	private MiningBO miningBO;
	
	@Autowired
	private UserRolesService userRolesServiceImpl;
	
	final static Logger logger = LoggerFactory.getLogger(MiningRestController.class);

	/**
	 * customer registration service
	 * 
	 * @param user
	 * @return string
	 * @throws MiningException
	 */
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/register", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createCustomer(@RequestBody UserInfo user)
			throws MiningException {
		logger.debug("createCustomer method starts");
		String flag = MiningConstants.failed;
		if (null != user) {
			flag = userServiceImpl.saveUser(user);
		}
		logger.debug("createCustomer method ends");
		return new ResponseEntity<String>(flag, HttpStatus.OK);
	}
	
	/**
	 * customer login service
	 * 
	 * @param user
	 * @return string
	 * @throws MiningException
	 */	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> loginCustomer(@RequestBody UserInfo user)
			throws MiningException {
		logger.debug("loginCustomer method starts");
		String flag = "failed";
		if (null != user) {
			flag = miningBO.loginUser(user);
		}
		logger.debug("loginCustomer method ends");
		return new ResponseEntity<String>(flag, HttpStatus.OK);
	}
	
	/**
	 * work order service
	 * 
	 * @param workOrderInfo
	 * @return string
	 * @throws MiningException
	 */
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/workorder/create", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createWorkOrder(@RequestBody WorkOrderInfo workOrderInfo)
			throws MiningException {
		logger.debug("createWorkOrder method starts");
		String flag = MiningConstants.failed;
		if (null != workOrderInfo) {
			flag = workOrderServiceImpl.saveWorkOrder(workOrderInfo);
		}
		logger.debug("createWorkOrder method ends");
		return new ResponseEntity<String>(flag, HttpStatus.OK);
	}

	/**
	 * stone details service
	 * 
	 * @param stoneInfo
	 * @return string
	 * @throws MiningException
	 */
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/stone/create", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createStoneDetails(@RequestBody StoneInfo stoneInfo)
			throws MiningException {
		logger.debug("createStoneDetails method starts");
		String flag = MiningConstants.failed;
		if (null != stoneInfo) {
			flag = stoneServiceImpl.saveStoneDetails(stoneInfo);
		}
		logger.debug("createStoneDetails method ends");
		return new ResponseEntity<String>(flag, HttpStatus.OK);
	}
	
	/**
	 * forgot password service
	 * 
	 * @param userInfo
	 * @return string
	 * @throws MiningException
	 */
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> forgotPassword(@RequestBody UserInfo userInfo)
			throws MiningException {
		logger.debug("forgotPassword method starts");
		String flag = MiningConstants.failed;
		if (null != userInfo) {
			flag = userServiceImpl.forgotPassword(userInfo);
		}
		logger.debug("forgotPassword method ends");
		return new ResponseEntity<String>(flag, HttpStatus.OK);
	}
	
	/**
	 * save image service
	 * 
	 * @param file
	 * @return string
	 * @throws MiningException
	 * @throws IOException
	 */
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/image", method = RequestMethod.POST, headers = "Accept=multipart/form-data")
	public ResponseEntity<String> saveImage(@RequestParam("file") MultipartFile file)
			throws MiningException, IOException {
		logger.debug("saveImage method starts");
		String flag = MiningConstants.failed;
		if (!file.isEmpty()) {
			byte[] image = file.getBytes();
			StoneImageInfo stoneImageInfo = new StoneImageInfo();
			stoneImageInfo.setImgeName(file.getOriginalFilename());
			stoneImageInfo.setImage(image);
			flag = stoneServiceImpl.saveStoneImage(stoneImageInfo);
		}
		logger.debug("saveImage method ends");
		return new ResponseEntity<String>(flag, HttpStatus.OK);
	}
	
	/**
	 * Get all images service
	 * 
	 * @return List
	 * @throws MiningException
	 */
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/getImages", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<StoneImageInfo>> getAllImages()
			throws MiningException {
		logger.debug("getAllImages method starts");
		List<StoneImageInfo> images = userServiceImpl.getAllImages();	
		logger.debug("getAllImages method ends");
		return new ResponseEntity<List<StoneImageInfo>>(images, HttpStatus.OK);
	}
	
	/**
	 * Get all stone details service
	 * 
	 * @return List
	 * @throws MiningException
	 */
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/getStoneDetails", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<StoneInfo>> getStoneDetails()
			throws MiningException {
		logger.debug("getAllImages method starts");
		List<StoneInfo> stoneList = stoneServiceImpl.getStoneDetails();	
		logger.debug("getAllImages method ends");
		return new ResponseEntity<List<StoneInfo>>(stoneList, HttpStatus.OK);
	}
	
	/**
	 * Get all work order details service
	 * 
	 * @return List
	 * @throws MiningException
	 */
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/getWorkOrderDetails", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<WorkOrderInfo>> getWorkOrderDetails()
			throws MiningException {
		logger.debug("getWorkOrderDetails method starts");
		List<WorkOrderInfo> woList = workOrderServiceImpl.getWorkOrderDetails();	
		logger.debug("getWorkOrderDetails method ends");
		return new ResponseEntity<List<WorkOrderInfo>>(woList, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="*",maxAge=3600)
	@RequestMapping(value="/saveOrganisation",method=RequestMethod.POST,headers = "Accept=application/json")
	public ResponseEntity<String> createOrganisation(@RequestBody OrganisationInfo org) throws MiningException
	{
		String flag=MiningConstants.failed;
		if(org!=null)
		{
			flag=organisationServiceImpl.saveOrganisation(org);
		}
		return new ResponseEntity<String>(flag, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="*", maxAge=3600)
	@RequestMapping(value="/getOrganisationList",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<List<OrganisationInfo>> getOrganisationList() throws MiningException
	{
		logger.debug("get all organisation values starts");
	
		List<OrganisationInfo> orgList=organisationServiceImpl.organisationList();
		
		logger.debug("get all organisation values ends");
		return new ResponseEntity<List<OrganisationInfo>>(orgList,HttpStatus.OK);
	}
	
	@CrossOrigin(origins="*",maxAge=3600)
	@RequestMapping(value="/getUserRolesList",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<List<UserRolesInfo>> getUserRolesList() throws MiningException
	{
		logger.debug("get all user roles values starts ");
		List<UserRolesInfo> listuserroles=userRolesServiceImpl.getUserRoles();		
		logger.debug("get all user roles values end" );
		
		return new ResponseEntity<List<UserRolesInfo>>(listuserroles,HttpStatus.OK);
	}
	
	@CrossOrigin(origins="*",maxAge=3600)
	@RequestMapping(value="/saveUserRoles",method=RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<String> saveUserRoles(@RequestBody UserRolesInfo info) throws MiningException
	{
		String flag=MiningConstants.failed;
		if(info!=null)
		{
			flag=userRolesServiceImpl.saveUserRoles(info); 
		}
		return new ResponseEntity<String>(flag,HttpStatus.OK);
	}
	
	@CrossOrigin(origins="*",maxAge=3600)
	@RequestMapping(value={"/getApprovalPendingList"},method=RequestMethod.GET,headers="Accept=application/json")
	//@RequestMapping(value={"/getApprovalPendingList"},method=RequestMethod.GET,headers="Accept=application/json")
	//public ResponseEntity<List<UserInfo>> getPendingApprovels(@RequestParam(value="searchBy",required=false) String searchBy,@RequestParam(value="searchVal",required=false) String searchVal)throws MiningException
	public ResponseEntity<List<UserInfo>> getPendingApprovels(@RequestParam(value="searchBy") String searchBy,@RequestParam(value="searchVal") String searchVal)throws MiningException
	{
		
		logger.debug("get pending approvels values starts" +searchBy +"---"+searchVal);
		List<UserInfo> info=userServiceImpl.getPendingApprovels(searchBy,searchVal);
		logger.debug("get pending approvels values Ends");
		return new ResponseEntity<List<UserInfo>>(info,HttpStatus.OK);
	}
	
	@CrossOrigin(origins="*",maxAge=3600)
	@RequestMapping(value="/saveUserApprovel",method=RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<String> saveUserApprovelValues(@RequestBody UserApprovelInfo appInfo) throws MiningException
	{
		String flag=MiningConstants.failed;
		logger.debug("User approvel values in Mining rest controller starts");
		flag=userServiceImpl.saveUserApprovel(appInfo);
		logger.debug("User approvel values in Mining rest controller ends");
		return new ResponseEntity<String>(flag,HttpStatus.OK);
	}
	@CrossOrigin(origins="*",maxAge=3600)
	@RequestMapping(value="/getStatusInfoValues",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<List<StatusInfo>> getStatusList()throws MiningException
	{
		logger.debug("get status details values starts");
		List<StatusInfo> statusInfos=userServiceImpl.getStatusValues(null);
		logger.debug("get status details values ends");
		return new ResponseEntity<List<StatusInfo>>(statusInfos,HttpStatus.OK);
	}
	/**
	 * Get server URL
	 * 
	 * @return List
	 * @throws MiningException
	 */
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/getServerUrl", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<String> getServerUrl()
			throws MiningException {
		logger.debug("get Server Url method starts");
		String serverUrl = userServiceImpl.getServerUrl();	
		logger.debug("get Server Url method ends");
		return new ResponseEntity<String>(serverUrl, HttpStatus.OK);
	}
}
