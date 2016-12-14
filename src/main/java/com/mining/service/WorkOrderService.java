package com.mining.service;

import com.mining.exception.MiningException;
import com.mining.model.JSON.WorkOrderInfo;

public interface WorkOrderService {
	
	String saveWorkOrder(WorkOrderInfo workOrderInfo)throws MiningException;
}
