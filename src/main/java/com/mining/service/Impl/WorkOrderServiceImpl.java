package com.mining.service.Impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mining.dao.WorkOrderDAO;
import com.mining.exception.MiningException;
import com.mining.model.WorkOrder;
import com.mining.model.JSON.WorkOrderInfo;
import com.mining.service.WorkOrderService;

@Service("workOrderServiceImpl")
public class WorkOrderServiceImpl implements WorkOrderService {
	@Autowired
	private WorkOrderDAO workOrderDAOImpl;
	
	final static Logger logger = LoggerFactory
			.getLogger(WorkOrderServiceImpl.class);
	/**
	 * saveWorkOrder
	 * 
	 */
	public String saveWorkOrder(WorkOrderInfo workOrderInfo)
			throws MiningException {
		logger.debug("saveWorkOrder method starts");
		logger.debug("saveWorkOrder method ends");
		return workOrderDAOImpl.saveWorkOrder(processworkOrderInfo(workOrderInfo));
	}
	
	/**
	 * processworkOrderInfo
	 * 
	 */
	private WorkOrder processworkOrderInfo(WorkOrderInfo workOrderInfo) {
		logger.debug("processworkOrderInfo method starts");
		WorkOrder workOrder = new WorkOrder();
		if (null != workOrderInfo) {
			workOrder.setEmpName(workOrderInfo.getEmpName());
			workOrder.setTimeIN(workOrderInfo.getTimeIN());
			workOrder.setTimeOUT(workOrderInfo.getTimeOUT());
			workOrder.setWorkedHours(workOrderInfo.getWorkedHours());
			workOrder.setCreatedBy(workOrderInfo.getEmpName());
			workOrder.setCreationDate(new Date());
		}
		logger.debug("processworkOrderInfo method ends");
		return workOrder;
	}

}
