package com.mining.dao;

import java.util.List;

import com.mining.exception.MiningException;
import com.mining.model.WorkOrder;
import com.mining.model.JSON.WorkOrderInfo;

public interface WorkOrderDAO {
	String saveWorkOrder(WorkOrder workOrder)throws MiningException;

	List<WorkOrderInfo> getWorkOrderDetails()throws MiningException;
}
