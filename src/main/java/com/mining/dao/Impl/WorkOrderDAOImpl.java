package com.mining.dao.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mining.dao.AbstractDao;
import com.mining.dao.WorkOrderDAO;
import com.mining.exception.MiningException;
import com.mining.model.WorkOrder;
import com.mining.util.MiningConstants;

@Repository("workOrderDAOImpl")
public class WorkOrderDAOImpl extends AbstractDao<Integer, WorkOrder> implements
		WorkOrderDAO {
	
	final static Logger logger = LoggerFactory
			.getLogger(WorkOrderDAOImpl.class);
	/**
	 * saveWorkOrder
	 * 
	 */
	public String saveWorkOrder(WorkOrder workOrder) throws MiningException {
		logger.debug("saveWorkOrder method starts");
		saveOrUpdate(workOrder);
		logger.debug("saveWorkOrder method ends");
		return MiningConstants.success;
	}

}
