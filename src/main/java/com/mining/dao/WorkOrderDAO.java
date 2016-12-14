package com.mining.dao;

import com.mining.exception.MiningException;
import com.mining.model.WorkOrder;

public interface WorkOrderDAO {
	String saveWorkOrder(WorkOrder workOrder)throws MiningException;
}
