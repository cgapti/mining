package com.mining.dao.Impl;

import org.springframework.stereotype.Repository;

import com.mining.dao.AbstractDao;
import com.mining.dao.WorkOrderDAO;
import com.mining.exception.MiningException;
import com.mining.model.WorkOrder;

@Repository("workOrderDAOImpl")
public class WorkOrderDAOImpl extends AbstractDao<Integer, WorkOrder> implements
		WorkOrderDAO {

	public String saveWorkOrder(WorkOrder workOrder) throws MiningException {
		System.out.println("WorkOrderDAOImpl - saveUser method starts");
		saveOrUpdate(workOrder);
		System.out.println("MiningDAOImpl - saveUser method starts");
		return "success";
	}

}
