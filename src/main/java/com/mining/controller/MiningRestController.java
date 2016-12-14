package com.mining.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mining.bo.MiningBO;
import com.mining.exception.MiningException;
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
}
