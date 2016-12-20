package com.mining.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mining.bo.MiningBO;
import com.mining.exception.MiningException;
import com.mining.model.JSON.StoneImageInfo;
import com.mining.model.JSON.StoneInfo;
import com.mining.model.JSON.UserInfo;
import com.mining.model.JSON.WorkOrderInfo;
import com.mining.service.StoneService;
import com.mining.service.UserService;
import com.mining.service.WorkOrderService;

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
	private MiningBO miningBO;

	@RequestMapping(value = "/register", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createCustomer(@RequestBody UserInfo user)
			throws MiningException {
		System.out
				.println("MiningRestController - createCustomer method starts");
		String flag = "failed";
		if (null != user) {
			flag = userServiceImpl.saveUser(user);
		}
		System.out
				.println("MiningRestController -  createCustomer method ends");
		return new ResponseEntity<String>(flag, HttpStatus.OK);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> loginCustomer(@RequestBody UserInfo user)
			throws MiningException {
		System.out
				.println("MiningRestController - loginCustomer method starts");
		String flag = "failed";
		if (null != user) {
			flag = miningBO.loginUser(user);
		}
		System.out.println("MiningRestController -  loginCustomer method ends");
		return new ResponseEntity<String>(flag, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/workorder/create", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createWorkOrder(@RequestBody WorkOrderInfo workOrderInfo)
			throws MiningException {
		System.out
				.println("MiningRestController - createWorkOrder method starts");
		String flag = "failed";
		if (null != workOrderInfo) {
			flag = workOrderServiceImpl.saveWorkOrder(workOrderInfo);
		}
		System.out.println("MiningRestController -  createWorkOrder method ends");
		return new ResponseEntity<String>(flag, HttpStatus.OK);
	}

	@RequestMapping(value = "/stone/create", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createStoneDetails(@RequestBody StoneInfo stoneInfo)
			throws MiningException {
		System.out
				.println("MiningRestController - createStoneDetails method starts");
		String flag = "failed";
		if (null != stoneInfo) {
			flag = stoneServiceImpl.saveStoneDetails(stoneInfo);
		}
		System.out.println("MiningRestController -  createStoneDetails method ends");
		return new ResponseEntity<String>(flag, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getusers", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<UserInfo>> getUsers()
			throws MiningException {
		System.out
				.println("MiningRestController - getUsers method starts");
		List<UserInfo> userList = new ArrayList<UserInfo>();
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("malli");
		userInfo.setPassword("pwd123");
		userInfo.setPhoneNumber("123456789");
		userInfo.setEmail("mmm@gmail.com");
		userInfo.setRole("Admin");
		userList.add(userInfo);
		System.out
				.println("MiningRestController -  getUsers method ends");
		return new ResponseEntity<List<UserInfo>>(userList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> forgotPassword(@RequestBody UserInfo userInfo)
			throws MiningException {
		System.out
				.println("MiningRestController - forgotPassword method starts");
		String flag = "failed";
		if (null != userInfo) {
			flag = userServiceImpl.forgotPassword(userInfo);
		}
		System.out.println("MiningRestController -  forgotPassword method ends");
		return new ResponseEntity<String>(flag, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/image", method = RequestMethod.POST, headers = "multipart/form-data")
	public ResponseEntity<String> storeImage(@RequestParam("file") MultipartFile file)
			throws MiningException, IOException {
		System.out
				.println("MiningRestController - forgotPassword method starts");
		String flag = "failed";
		if (!file.isEmpty()) {
			byte[] image = file.getBytes();
			StoneImageInfo stoneImageInfo = new StoneImageInfo();
			stoneImageInfo.setImgeName(file.getOriginalFilename());
			stoneImageInfo.setImage(image);
			flag = stoneServiceImpl.saveStoneImage(stoneImageInfo);
		}
		System.out.println("MiningRestController -  forgotPassword method ends");
		return new ResponseEntity<String>(flag, HttpStatus.OK);
	}
	
}
