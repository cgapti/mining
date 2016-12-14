package com.mining.service.Impl;

import java.util.Date;

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

	public String saveWorkOrder(WorkOrderInfo workOrderInfo)
			throws MiningException {
		System.out.println("WorkOrderServiceImpl - saveWorkOrder method starts");
		System.out.println("WorkOrderServiceImpl - saveWorkOrder method ends");
		return workOrderDAOImpl.saveWorkOrder(processworkOrderInfo(workOrderInfo));
	}

	private WorkOrder processworkOrderInfo(WorkOrderInfo workOrderInfo) {
		System.out.println("WorkOrderServiceImpl - processworkOrderInfo method starts");
		WorkOrder workOrder = new WorkOrder();
		if (null != workOrderInfo) {
			workOrder.setEmpName(workOrderInfo.getEmpName());
			workOrder.setTimeIN(workOrderInfo.getTimeIN());
			workOrder.setTimeOUT(workOrderInfo.getTimeOUT());
			workOrder.setWorkedHours(workOrderInfo.getWorkedHours());
			workOrder.setCreatedBy(workOrderInfo.getEmpName());
			workOrder.setCreationDate(new Date());
		}
		System.out.println("WorkOrderServiceImpl - processworkOrderInfo method starts");
		return workOrder;
	}

}
