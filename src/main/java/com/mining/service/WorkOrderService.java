package com.mining.service;

import java.util.List;

import com.mining.exception.MiningException;
import com.mining.model.JSON.WorkOrderInfo;

public interface WorkOrderService {
	
	String saveWorkOrder(WorkOrderInfo workOrderInfo)throws MiningException;

	List<WorkOrderInfo> getWorkOrderDetails()throws MiningException;
}
